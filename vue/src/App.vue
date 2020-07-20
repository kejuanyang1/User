<template>
  <div id="app">
    <el-container>
      <el-header  style="height:150px; text-align: center; font-size: 35px; background-color: #1abc9c;
                      color: white; line-height: 150px;">
        <strong>睿信书院会议预约系统</strong></el-header>
      <router-view></router-view>
    </el-container>
  </div>
</template>

<script>
  export default {
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };
</script>
