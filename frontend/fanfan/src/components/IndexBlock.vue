<template>
    <div class="indexblock radius" style="background-image:url({{ imgurl}})">
        <div class="label radius">
            {{ msg }}
        </div>
    </div>
</template>

<script>
export default {
    name: 'IndexBlock',
    props: {
        msg: String,
        imgUrl: String
    }
}
</script>

<style>
.radius{
    border-radius: 2%;
}
.indexblock {
    background-image: url("/src/assets/dish1.jpg");
    background-size: 100% 100%;
    height: 120px;
    width: 160px;
    background-color: rgb(255, 255, 255);
    box-shadow: 5px 5px 5px rgb(124, 124, 124);
}

.label {
    align-self: center;
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    color: white;
    background-color: rgba(38, 38, 38, 0.505);
}
</style>