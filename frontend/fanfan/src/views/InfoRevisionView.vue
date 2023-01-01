<template>
    <div class="topBar">
        <div class="back" @click="JumpBack()">
            <nut-icon name="left" size="15px"></nut-icon>
        </div>
    </div>
</template>

<script>
export default {
    methods: {
        JumpBack() {
            this.$router.back();
        }
    }
}
</script>

<style>
.topBar {
    margin: 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
</style>