<template>
  <div v-loading="loading" class="wrapper">
    <el-card class="transfer">
      <template #header>
        <span>
          <div class="card-header">
            <el-form label-position="left" inline class="info-table">
              <el-form-item label="用户名">
                <span v-if="row && row.userName">{{ row.userName }}</span>
              </el-form-item>
            </el-form>
          </div>
        </span>
      </template>
      <el-transfer v-model="menu.form" v-loading="menu.loading" :data="menu.data" :titles="['菜单','已授权']"> </el-transfer>
    </el-card>
    <br />
    <el-row class="btns">
      <el-button size="mini" type="primary" @click="saveData"> <i class="fa fa-check"> </i> 确认修改 </el-button>
    </el-row>
  </div>
</template>
<script lang="ts">
import { computed, defineComponent, onMounted, watchEffect, reactive, toRef, toRefs } from 'vue'
import { useStore } from '@/store'
import Service from '../api'
import {ElMessage} from "element-plus";

interface stateTypes {
  url: String
  purl: String
  loading: Boolean
  form: { key: String; label: String }
  menu: {
    loading: Boolean
    url: String
    data: { key: String; label: String }[]
    form: String[]
  }
}
export default defineComponent({
  name: 'WorkersEdit',
  props: {
    currentRow: {
      type: Object,
      default: () => ({ userId:null,userName:'',userDepartment:'',userRole: ''})
    }
  },
  emits: ['success'],

  setup(props, { emit }) {
    // 析构获取 props 属性 basePath
    const currentRow = toRef(props, 'currentRow')
    const store = useStore()
    const lang = computed(() => store.getters['settingsModule/getLangState'])

    const state = reactive<stateTypes>({
      url: `/worker/allow`,
      purl: `/worker/permissions`,
      loading: false,
      form: { key: '', label: '' },
      menu: {
        loading: false,
        url: `/menu/list`,
        data: [],
        form: []
      }
    })

    const row = computed(() => currentRow.value)
    // 可访问
    const routes = computed(() => store.state.permissionModule.routes)

    /**
     * @description 异步获取已经授权的菜单
     */
    const fetchData = async () => {
      const data = {
        roleName: row.value.userRole
      }
      // 后端根据角色名称，查询授权菜单
      const res = await Service.postAuthPermission(data)
      if (res?.data) {
        const { authedRoutes } = res.data
        state.menu.form = authedRoutes
      }
    }
    /**
     * @description 异步获取所有的菜单
     */
    const fetchMenuData = () => {
      // 模拟获取所有菜单数据；
      // eslint-disable-next-line no-restricted-syntax
      for (const i of routes.value) {
        if (!i?.meta?.hidden) {
          state.menu.data.push({
            key: i?.path,
            label: i?.meta?.title[lang.value] as String
          })
        }
      }
      console.log(state.menu)
    }

    /**
     * @description 保存当前角色授权菜单
     */
    const saveData = async() => {
      const data = {
        "authedRoutes":state.menu.form,
        "userId":row.value.userId,
        "accessToken":sessionStorage.getItem("accessToken")
      }
      console.log('form is ', data)
      const res = await Service.postManagerUpdateMenu(data)
      if(res.status === 0) {
        ElMessage(
            {
              type: 'success',
              message: res.message,
            }
        )
        emit('success')
      }
      else{
        ElMessage(
            {
              type: 'error',
              message: res.message,
            }
        )
      }
    }
    onMounted(() => {
      // 获取 auth Menu Info
      fetchMenuData()
    })
    // 使用watchEffect 监听所用到的变化时做出的副作用反应；
    watchEffect(() => {
      fetchData()
    })
    return {
      ...toRefs(state),
      lang,
      row,
      fetchMenuData,
      saveData
    }
  }
})
</script>
<style lang="stylus" scoped>
.btns {
  text-align: right;
}

.el-transfer {
  display: inline-block;
  text-align: left;
}

.transfer {
  text-align: center;
}

.card-header {
  text-align: left;
}
</style>
