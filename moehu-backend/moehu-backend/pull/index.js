const app = require('express')(),
      exec = require('child_process').execFile;

app.post('/pull', (req, res) => {
    exec('/root/moehu-backend/pull/pull.sh',{
        cwd: './',
        encoding: 'utf8',
        stdio: 'inherit'
    }, (err, stdout, stderr) => {
        if (err) {
            console.log(`命令执行错误 err：${err}`)
            console.log(`命令执行错误 stdout：${stdout}`)
            console.log(`命令执行错误 stderr ：${stderr}`)
            res.json({
                title: 'error',
                message: err.message
            })
        } else {
            console.log(`命令成功错误 err：${err}`)
            console.log(`命令成功错误 stdout：${stdout}`)
            console.log(`命令成功错误 stderr ：${stderr}`)
            res.json({
                title: 'success1',
            })
        }

        res.json({
            title: 'success2',
        })
    });
})

app.listen(1314, () => {
    console.log('Node.js自动部署运行在: 1314')
})