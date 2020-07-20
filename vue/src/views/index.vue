<template>
    <el-container style="height: 850px">
        <el-header style="text-align: right; background-color: black; color: white;">
            <i class="el-icon-user" style="font-size: 30px; line-height: 60px"></i>
        </el-header>

        <el-main>
            <router-view></router-view>
        </el-main>
    </el-container>
</template>

<script>
    export default {
        name: "index"
    }
</script>

<style scoped>

</style>