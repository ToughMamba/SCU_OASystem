<template>
  <div>
    <el-alert title="Tips:点击【编辑】按钮，进行不同角色的菜单授权操作！" type="warning"> </el-alert>
    <el-alert title="Tips:权限控制体验：【管理员账号为：admin@outlook.com】、【超级管理员账号为：super@outlook.com】" type="info"> </el-alert>
    <el-card class="card-ctrl">
      <el-row>
        <el-col :span="8" style="text-align: left">
          <el-button type="primary" size="small" @click="onDistributeTodo">
            <el-icon><plus /></el-icon>
            分派任务</el-button
          >
          <el-button type="success" size="small" @click="onDistributeMeeting">
            <el-icon><plus /></el-icon>
            新建会议</el-button
          >
        </el-col>
      </el-row>
      <br />
      <el-table v-loading="loading" :data="data" stripe class="table" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center"></el-table-column>
        <el-table-column prop="userName" label="用户名" align="center"></el-table-column>
        <el-table-column prop="userDepartment" label="部门" align="center"></el-table-column>
        <el-table-column prop="userRole" label="职位" align="center"></el-table-column>
        <el-table-column prop="userPhone" label="电话号码" align="center"></el-table-column>

        <el-table-column label="操作" align="center">
          <template #default="scope">
            <el-tooltip class="item" effect="dark" content="菜单授权" placement="bottom">
              <el-button circle plain type="primary" size="small" @click="onEdit(scope.$index, scope.row)">
                <el-icon><edit /></el-icon>
              </el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          :current-page="param.page"
          :page-size="param.limit"
          layout="sizes,prev,pager,next,total"
          :page-sizes="[5, 10, 20]"
          :total="total"
          background
          @current-change="onCurrentChange"
          @size-change="onSizeChange"
        >
        </el-pagination>
      </div>
    </el-card>
    <el-dialog v-model="edit_visible" center :title="posted.userRow.userRole">
      <worker-edit :current-row="posted.userRow" @success="onEditSuccess"></worker-edit>
    </el-dialog>
    <el-dialog v-model="todo_visible" center :title="posted.userRow.userRole">
      <distribute-todo :userIds="selectionRows" @success="onDistributeTodoSuccess"></distribute-todo>
    </el-dialog>
    <el-dialog v-model="meeting_visible" center :title="posted.userRow.userRole">
      <distribute-meeting :userIds="selectionRows" @success="onDistributeMeetingSuccess"></distribute-meeting>
    </el-dialog>
  </div>
</template>
<script lang="ts">
import { defineComponent, reactive, toRefs, computed } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { Edit, Minus, Plus, Refresh } from '@element-plus/icons-vue'
import WorkerEdit from './workersEdit.vue'
import DistributeTodo from "@/views/Worker/distributeTodo.vue";
import DistributeMeeting from "@/views/Worker/distributeMeeting.vue";
import Service from './api/index'
import RoleEdit from "@/views/Role/rolesEdit.vue";
import RoleNew from "@/views/Role/rolesNew.vue";

export default defineComponent({
  name: 'WorkerManage',
  components: {
    WorkerEdit,
    DistributeTodo,DistributeMeeting,
    RoleNew,
    RoleEdit,
    Edit,
    Minus,
    Plus,
    Refresh
  },
  setup() {
    const state = reactive({
      url: {
        c: '/worker/add',
        r: '/worker/list',
        u: '/worker/update',
        d: '/worker/delete'
      },
      param: {
        limit: 10,
        page: 1
      },
      data: [
        //{ userName: '超级管理员', userDepartment:'',userRole:'',userPhone:''},
      ],
      loading: false,
      is_search: false,
      edit_visible: false,
      detail_visible: false,
      todo_visible: false,
      meeting_visible: false,
      posted: {
        userRow: {
          userId: null,
          userName:'',
          userRole: '',
          userDepartment:''
        }
      },
      selectionRows: [] as { userId: number }[], // 假设 userId 是字符串或数字
    })
    // 动态计算total;
    const total = computed(() => state.data.length)
    /**
     * @description 请求接口获取当前设置角色，默认始终有超级管理员角色
     */
    const fetchData = async() => {
      state.is_search = false
      const data = {'accessToken':sessionStorage.getItem('accessToken')}
      const adminUserInfo = await Service.postAdminQueryUserList(data)
      if (adminUserInfo.status === 0) {
        state.data = adminUserInfo.data.map((item: any) => ({
          ...item,
          isSelect: false
        }));
      }
    }
    /**
     * @description 实时更新选择行的userId列表
     */
    const handleSelectionChange = (selection:any[]) => {
      state.selectionRows = selection.map(item => item.userId)
      console.log("SelectionRows",state.selectionRows)
    }
    const onCurrentChange = () => {
      fetchData()
    }

    const onSizeChange = (val: number) => {
      state.param.limit = val
      fetchData()
    }
    const onDistributeTodo = () => {
      state.todo_visible = true
    }
    const onDistributeMeeting = () => {
      state.meeting_visible = true
    }
    const onDistributeTodoSuccess = () => {
      state.todo_visible = false
    }
    const onDistributeMeetingSuccess = () => {
      state.meeting_visible = false
    }
    const onEditSuccess = () => {
      state.edit_visible = false
      fetchData()
    }
    /**
     * @description 选择点击编辑授权角色；roleName
     */
    const onEdit = (index: any, row: any) => {
      console.log('row', row)
      state.posted.userRow.userName = row.userName
      state.posted.userRow.userRole = row.userRole
      state.posted.userRow.userDepartment = row.userDepartment
      state.edit_visible = true
    }

    fetchData()
    return {
      ...toRefs(state),
      total,
      handleSelectionChange,
      onCurrentChange,
      onSizeChange,
      onDistributeTodo,
      onDistributeTodoSuccess,
      onDistributeMeeting,
      onDistributeMeetingSuccess,
      onEdit,
      onEditSuccess,
      fetchData
    }
  }
})
</script>
<style lang="stylus" scoped></style>
