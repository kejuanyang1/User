<template>
    <el-container style="height: 600px">
        <el-aside width="1080px">
            </el-aside>
        <el-main>
            <h2 class="title">用户登录</h2><br>
            <div class="login_form" >
                <el-form ref="user" :model="user" height="600px" label-width="80px auto">
                    <el-form-item label="用户名">
                        <el-input v-model="user.name"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input type="password" v-model="user.password"></el-input>
                    </el-form-item>

                    <el-link href="http://localhost:8080/register" style="float: right" target="_blank">立即注册</el-link><br><br><br><br>

                    <el-form-item>
                        <div align="center">
                        <el-button type="primary" style="font-size: 18px" @click="login">登录</el-button>
                        </div>
                    </el-form-item>
                </el-form>
            </div>
        </el-main>
    </el-container>

</template>

<style>
    .el-header {
        color: #333;
        line-height: 60px;
    }

    .el-aside{
        background-image: url("../views/images/timg.jpg");
        background-repeat:no-repeat;
        background-size: 100%;
    }

    .el-main{
        padding-left: 10%;
    }

    .login_form {
        padding-top: 5%;
        padding-left: 10%;
        padding-right: 10%;
    }

    .title{
        line-height: 50px;
        text-align: center;
        border-bottom: 1px solid silver;
    }

</style>

<script>
    export default {
        name: "Main",
        data() {
            return {
                user: {
                    name: '',
                    password: '',
                }
            }
        },
        methods: {
            //登陆方法
            login(){
                this.$axios.post("http://localhost:8989/user/login", this.user).then( res => {
                    console.log(res.data);
                    if(res.data.state){
                        alert(res.data.msg+'点击确定进入主页');
                        location.href="https://element.eleme.io";
                    }else{
                        alert(res.data.msg)
                    }
                });
            }

        }
    }
</script>


<style>

</style>