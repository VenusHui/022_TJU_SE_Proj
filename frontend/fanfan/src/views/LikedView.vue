<template>
    <div class="likedframebox">
        <div class="likedtopbox">
            <div class="logotitle logocolor" style="margin-left: 10px;">
                <b>Liked</b>
            </div>
        </div>
        <div class="likedlist">
            <div class="likeditem" @click="JumpDetail">
                
            </div>
            <div class="likeditem" @click="JumpDetail">
                
            </div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
export default {
    setup() {
        const value = ref(3);
        return { value }
    },
    methods: {
        JumpDetail() {
            this.$router.push('/detail')
        }
    }
}
</script>

<style>
.likedframebox {
    /* padding: 10px; */
}
.likedtopbox{
    margin: 10px;
}
.likeditem{
    background-color: white;
    margin: 5px;
    border-radius: 3%;
}
</style>