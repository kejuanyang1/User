<template>
    <el-container style="height: 600px" >
        <el-header style="text-align: right" height="20px">
            <div class ="now_login"><el-link type="test" style="margin:0;" @click="login">我已注册，立即登录</el-link></div>
        </el-header>
        <el-container width="800px">
        <el-form :model="user" status-icon :rules="rules" ref="user" label-width="100px" class="demo-user">
            <el-form-item label="姓名" prop="name">
                <el-input type="text" v-model="user.name" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="学号/工号" prop="num">
                <el-input type="text" v-model="user.num" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="设置密码" prop="password">
                <el-input type="password" v-model="user.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" v-model="user.checkPass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="手机号码" prop="tel">
                <el-input type="text" v-model="user.tel" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="注册身份" prop="job">
                <el-select v-model="user.job">
                    <el-option label="学生" value="student"></el-option>
                    <el-option label="管理员" value="teacher"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item prop="checkbox">
                <el-checkbox v-model="user.checkbox" style="margin-right: 10px"></el-checkbox> 阅读并接受
                    <el-link href="https://element.eleme.io" :underline="false" target="_blank">《xxx用户协议》</el-link>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" style="width:200px" @click="submitForm('user')">注册</el-button>
            </el-form-item>
        </el-form>
        </el-container>
    </el-container>

</template>

<script>
    export default {
        name: "Register",
        data() {
            var EqualPass = (rule, value, callback) => {
                if (value !== this.user.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };

            var Numcheck = (rule, value, callback) => {
                const a=/^[0-9]{1,20}$/;
                if(!a.test(this.user.num)) {
                    callback(new Error('由数字构成'));
                } else {
                    callback();
                }
            };

            var Telcheck = (rule, value, callback) => {
                const b=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if(!b.test(this.user.tel)) {
                    callback(new Error('手机号码格式不正确'));
                } else {
                    callback();
                }
            };

            return {
                user: {
                    name: '',
                    num: '',
                    password: '',
                    checkPass: '',
                    tel: '',
                    job: '',
                    checkbox: false
                },
                rules: {
                    name: [
                        { required: true, message: '请输入真实姓名', trigger: 'blur' },
                        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    num: [
                        { required: true, message: '请输入学号/工号', trigger: 'blur' },
                        { validator: Numcheck, trigger: 'blur'}
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ],
                    checkPass: [
                        { required: true, message: '请重复密码', trigger: 'blur' },
                        { validator: EqualPass, trigger: 'blur'}
                    ],
                    tel:[
                        { required: true, message: '请输入手机号码', trigger: 'blur' },
                        { validator: Telcheck, trigger: 'blur'}
                    ],
                    job: [
                        { required: true, message: '请选择您的身份', trigger: 'change' }
                    ],
                    checkbox:[
                        { required: true }
                    ]
                }
            }
        },


        methods: {

            login(){
                location.href="http://localhost:8080/main"
            },

            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                            axios.post('http://localhost:8989/user/register',this.user).then(res=>{
                            console.log(res.data)
                            if(res.data.state){
                                alert(res.data.msg+"点击确定跳转至登录页面。");
                                location.href='http://localhost:8080/main';
                            }
                            else{
                                alert(res.data.msg);
                            }
                        })
                    }
                    else {
                        console.log('error submit!');
                        return false;
                    }
                });
            },

        }
    }
</script>

<style>
    .demo-user{
        margin: 100px auto;
    }

    .now_login {
        margin-top:0;
        margin-right:50px;
        font-size: 14px;
        margin-bottom: 0;
    }

</style>