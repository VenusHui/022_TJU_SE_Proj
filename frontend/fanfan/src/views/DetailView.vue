<template>
    <div class="detailframebox">
        <div class="detailtopbox">
            <div class="detailback" style="margin-right: 20px;"><nut-icon name="left"
                    size="15px"></nut-icon></div>
            <div class="detailtitle" style="font-size:25px">菜品详情</div>
        </div>
        <div class="detailbox" style="margin-bottom: 10px;">
            <div class="detailtitle marginbottom">
                章鱼小丸子
            </div>
            <div class="detailsubinfobox marginbottom">
                <div class="dishplace" style="margin-right:20px">小食堂二楼</div>
                <div class="dishprice">￥20</div>
            </div>
            <div class="detailimagebox">
                <img class="detailimage" src="../assets/dish4.jpg" />
            </div>
        </div>
        <div class="detailbox">
            <div class="commenttitle marginbottom">
                用户评价
            </div>
            <div class="detailscorebox marginbottom">
                <nut-icon name="star"></nut-icon>
                <nut-icon name="star"></nut-icon>
                <nut-icon name="star"></nut-icon>
                <nut-icon name="star"></nut-icon>
                <nut-icon name="star"></nut-icon>
                <div class="dishscore" style="margin-left:10px">4.5</div>
            </div>
            <div class="commentlist">
                <div class="commentitem marginbottom">
                    用户评价1
                </div>
                <div class="commentitem">
                    用户评价2
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>
.detailframebox {
    padding: 10px;
}

.detailtopbox {
    padding: 20px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
}
.detailbox {
    background-color: white;
    padding: 20px;
    border-radius: 3%;
}

.marginbottom {
    margin-bottom: 10px;
}

.detailtitle {
    font-size: 28px;
}

.detailsubinfobox {
    display: flex;
    font-size: small;
}

.detailimage {
    height: 25%;
    width: 100%;
    border-radius: 3%;
}

.detailscorebox {
    display: flex;
}

.commenttitle {
    font-size: 20px;
}
</style>