<template>
    <div class="topBar">
        <div class="back" @click="JumpBack()">
            <nut-icon name="left" size="15px"></nut-icon>
        </div>
    </div>
    <div class="form">
        <nut-form>
            <nut-form-item label="头像">
                <nut-uploader url="uploadUrl"></nut-uploader>
            </nut-form-item>
            <nut-form-item label="昵称">
                <input class="nut-input-text" placeholder="请输入昵称" type="text" />
            </nut-form-item>
            <nut-form-item label="年级">
                <input class="nut-input-text" placeholder="请输入年级" type="text" />
            </nut-form-item>
            <nut-form-item label="学院">
                <input class="nut-input-text" placeholder="请输入学院" type="text" />
            </nut-form-item>
            <nut-form-item label="酸">
                <nut-rate active-color="yellow" v-model="formData.value1" />
            </nut-form-item>
            <nut-form-item label="甜">
                <nut-rate active-color="pink" v-model="formData.value2" />
            </nut-form-item>
            <nut-form-item label="麻">
                <nut-rate active-color="green" v-model="formData.value3" />
            </nut-form-item>
            <nut-form-item label="辣">
                <nut-rate active-color="red" v-model="formData.value4" />
            </nut-form-item>
            <nut-cell title="地区" desc-text-align="left" :desc="desc" @click="()=>{formData.show=true}"></nut-cell>
            <nut-picker
                v-model:visible="formData.show"
                :columns="columns"
                title="请选择地区"
                @change="change"
                @confirm="confirm"
            >
            </nut-picker>
            <nut-cell title=" ">
                <template v-slot:link>
                    <nut-button type="primary" @click="Save()">保存</nut-button>
                </template>
            </nut-cell>
        </nut-form>
    </div>
</template>

<script>
import { reactive, ref } from 'vue';
export default {
    setup() {
        const desc = ref('');
        const formData = reactive({
            value1: 0,
            value2: 0,
            value3: 0,
            value4: 0,
            show: false,
        });
        const columns = ref([
            { text: '东北', value: '东北' },
            { text: '华北', value: '华北' },
            { text: '华中', value: '华中' },
            { text: '华南', value: '华南' },
            { text: '华东', value: '华东' },
            { text: '西北', value: '西北' },
            { text: '西南', value: '西南' },
        ]);
        const change = ({ selectedValue, selectedOptions }) => {
            console.log(selectedValue);
        };
        const confirm = ( { selectedValue, selectedOptions })=>{
            desc.value = selectedValue.join(',');
        };
        return { desc, formData, columns, change, confirm }
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        Save() {
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

.form {
    margin: 20px;
}
</style>