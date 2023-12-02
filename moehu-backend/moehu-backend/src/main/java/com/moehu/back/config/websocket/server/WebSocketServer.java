package com.moehu.back.config.websocket.server;


import com.alibaba.fastjson.JSONObject;

import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@ServerEndpoint("/websocket/{id}")
public class WebSocketServer {

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";
    /**
     * 连接建立成功后调用
     */
    @OnOpen
    public void onOpen(@PathParam(value = "id") String id, Session session) {

        RestTemplate restTemplate = new RestTemplate();
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=id;
        try {
            System.out.println("====================");
            String returnMessage="{\"messagetype\": 0,\"user_id\": 0,\"to_user_id\": "+sid+",\"content\": \"已连接\"}";
            sendMessage(returnMessage);
        } catch (Exception e) {
            System.out.println("websocket IO异常");
        }

    }

    /**
     * 连接关闭时调用
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1

        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用
     *
     * @param message 客户端发送过来的消息<br/>
     *                消息格式：内容 - 表示群发，内容|X - 表示发给id为X的客户端
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到来自窗口"+sid+"的信息:"+message);
        //群发消息
        JSONObject jsonObject=JSONObject.parseObject(message);
        System.out.println(jsonObject);
        System.out.println("to_user_id"+jsonObject.getString("to_user_id"));
        System.out.println("content:"+jsonObject.getString("content"));

//        String senddata="{messagetype:\""+jsonObject.getString("messagetype")+"\"," +
//                "user_id:"+jsonObject.getString("user_id")+"," +
//                "to_user_id:"+jsonObject.getString("to_user_id")+","+
//                "content:\""+jsonObject.getString("content")+"\""+
//                "}";
        try {
            sendInfo(message,jsonObject.getString("to_user_id"));
        }catch (Exception e){

        }

//        for (WebSocketServer item : webSocketSet) {
//            try {
//                item.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * 发生错误时回调
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("WebSocket发生错误");
        error.printStackTrace();
    }

    /**
     * 群发自定义消息vpy
     * */
    public static void sendInfo(String message,@PathParam("sid") String sid) throws IOException {
        System.out.println("推送消息到窗口"+sid+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(sid==null) {
                    item.sendMessage(message);
                }else if(item.sid.equals(sid)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    /**
     * 推送消息
     *
     * @param message 要推送的消息
     * @throws IOException
     */
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }




}
