<style lang="stylus" scoped>
.dragable-container{
  color #6c757d
  padding 0px 20px
  background-color #fafbfe

  .chart-widget-list p{
    border-bottom 1px solid #f1f3fa
    margin-bottom 0.5rem
    padding-bottom 0.5rem
    display flex
    flex-direction row
    justify-content space-between
    align-items center
  }

  .icon-square{
    width 12px
    height 12px
    display inline-block
  }
  .red{
    background-color #ec6769
  }
  .green{
    background-color  #93cb79
  }
  .yellow {
    background-color #f9c761
  }
  .deep-blue{
    background-color #5572c3
  }
  .page-title-box{
  box-sizing border-box
  display flex
  flex-direction row
  justify-content space-between
  align-items center
  .page-title{
    font-size  18px
    margin  0
    line-height  85px
    overflow  hidden
    white-space: nowrap
    text-overflow  ellipsis
    color  inherit
    font-weight 700
  }
  .page-title-right{
    display flex
    flex-direction row
    justify-content space-around
    align-items center
  }
}
  .flex{
    display flex
  }
  .flex-row{
    flex-direction row
  }
  .flex-column{
    flex-direction column
  }
  .flex-end{
    justify-content flex-end
  }
  .flex-start{
    justify-content flex-start
  }
  .flex-between{
    justify-content space-between
  }
  .text-muted{
    color #98a6ad
  }
  .align-center{
    align-items center
  }
  .text-norap{
    overflow:hidden;
    text-overflow:ellipsis;
    white-space:nowrap;
  }
  .margin-top-1{
    margin-top 10px
  }
  .margin-bottom-1{
    margin-bottom 10px
  }
  .margin-top-2{
    margin-top 20px
  }
  .margin-bottom-2{
    margin-bottom 20px
  }
  .margin-right-1{
    margin-right 10px
  }
  .padding-right-1{
    padding-right 10px
  }

  .badge{
    overflow: hidden;
    text-overflow: ellipsis;
    display: inline-block;
    padding: 0.25em 0.4em;
    font-size: 130%;
    font-weight: 700;
    line-height: 1;
    text-align: center;
    white-space: nowrap;
    vertical-align: baseline;
    border-radius: 0.25rem;
    -webkit-transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,-webkit-box-shadow .15s ease-in-out;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,-webkit-box-shadow .15s ease-in-out;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out,-webkit-box-shadow .15s ease-in-out;
  }
  .badge-secondary{
    color #fff
    background-color #6c757d
  }
  .badge-danger{
    color #fff
    background-color #fa5c7c
  }
  .badge-success{
    color: #fff;
    background-color: #0acf97;
  }

  .board{
    display: block;
    white-space: nowrap;
    overflow-x: auto;
    .task{
      display: inline-block;
      width: 22rem;
      padding: 0 1rem 1rem 1rem;
      border: 1px solid #e3eaef;
      vertical-align: top;
      margin-bottom: 30px;
      border-radius: 0.25rem;
      .task-header{
        background-color #f1f3fa
        padding 1rem
        margin 0 -1rem
        font-size 130%
      }
      .task-list-item{
        min-height 150px
        position relative
        .card {
        white-space normal
        margin-top 1rem
      }
      }
      &:not(:last-child) {
        margin-right: 1.25rem;
      }
    }

    .text-upercase{
      text-transform: uppercase!important;
    }
    .margin-top-0{
      margin-top 0 !important
    }
    h5{
      font-weight 700
      color  #6c757d
    }
    .name{
      margin-left 5px
    }
    .pointer{
      cursor pointer
    }

  }
  .info{
    text-align: left;
    padding-left: 20px;
    margin-bottom: 20px;
    font-size: 12px;
  }
  .section{
    display:flex;
    flex-direction:row;
    justify-content: flex-start;
    align-items :center;
  }

  .el-row {
    margin-bottom: 20px;
  }
  .box{
    background-color: var(--color-bg-primary);
    border: 1px solid var(--color-border-primary);
    border-radius: 6px;
    padding: 16px!important;
    display: flex!important;
    .item-list-content{
      display: flex;
      width: 100%;
      flex-direction: column;
    }
  }
  .box-card{
    margin-bottom :10px;
  }

  .external-events{
    cursor move
    margin 10px 0
    padding 8px 10px
    color #fff
    text-align left
    width 258.25px
    overflow hidden
    text-overflow ellipsis
    white-space nowrap

    .list-circle{
    width 14px
    height 14px
    border-radius 50%
    background-color white
    display inline-block
    margin-right: 10px
  }
  }
  :deep(.bg-success){
    background-color: #0acf97!important
  }
  :deep(.bg-info) {
    background-color: #39afd1!important;
  }
  :deep(.bg-danger) {
    background-color: #fa5c7c!important;
  }
  :deep(.bg-dark) {
    background-color: #313a46!important;
  }
  :deep(.bg-warning) {
    background-color: #ffbc00!important;
  }

  .text_line_limit {
    max-width: 110px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }

  .ellipsis-text {
    display: -webkit-box; /* 让元素成为弹性盒模型，支持多行截断 */
    -webkit-box-orient: vertical; /* 设置盒子为垂直排列 */
    overflow: hidden; /* 超出内容隐藏 */
    text-overflow: ellipsis; /* 超出部分显示省略号 */
    line-clamp: 2; /* 限制为 2 行 */
    -webkit-line-clamp: 2; /* 限制为 2 行（Webkit 内核支持） */
  }
}
</style>

<template>
  <div class="dragable-container">
    <el-row style="margin: 15px">
      <el-col :span="24" class="page-title-box">
        <h4 class="page-title">会议列表</h4>
      </el-col>
    </el-row>
    <el-row>
      <el-form :inline="true" :model="formInline" class="form-inline">
        <el-form-item>
          <el-button type="success" @click="onCreateMeeting()" :icon="CirclePlus">创建会议</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="success" @click="onAddMeeting()" :icon="CirclePlus">添加会议</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onDownload()" :icon="Download">打印</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onToExcel()" :icon="Download">导出</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onShowStatistics()" :icon="Odometer">统计信息</el-button>
        </el-form-item>
      </el-form>
      <el-form :inline="true" :model="formInline" class="form-inline">
        <el-form-item label="按">
          <el-select v-model="task.search_field" placeholder="无">
            <el-option label="无" value="none"></el-option>
            <el-option label="会议名称" value="mtin_title"></el-option>
            <el-option label="会议内容" value="mtin_ctnt"></el-option>
            <el-option label="会议ID" value="mtin_id"></el-option>
            <el-option label="会议开始时间" value="mtin_st"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-input v-model="task.search_key" placeholder="全局搜索"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSearchSubmit" :icon="Search">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="getPersonalMeetingList" :icon="Refresh"></el-button>
        </el-form-item>
      </el-form>


      <el-col :span="24">
        <div class="board">

          <div class="task">
            <h5 class="task-header text-upercase margin-top-0">已预订会议</h5>
            <div class="task-list-item">
              <template v-if="task.scheduled && task.scheduled.length">
              <el-card v-for="item in task.scheduled" :key="item.mtin_id" shadow="hover" class="card">
                <el-row>
                  <el-col :span="24" style="text-align: left">
                    <div class="flex flex-row flex-between">
                      <span class="badge badge-success">{{ item.mtin_title }}</span>
                      <small class="text-muted">会议ID：  {{ item.mtin_id }} </small>
                    </div>
                    <p class="name margin-top-1 margin-bottom-1">会议时间：{{ item.mtin_st }}</p>
                    <p class="text-muted margin-bottom-1 ellipsis-text">
                      <span class="margin-right-1"
                        ><el-icon size="19px"><ChatLineSquare /></el-icon>&nbsp;&nbsp;会议简介： {{ item.mtin_ctnt }}</span
                      >
                    </p>
                    <div class="flex flex-row flex-between">
                      <div class="flex flex-row flex-start align-center">
                        <el-avatar size="small" :src="item.avatar? item.avatar: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'"></el-avatar>
                        <p class="name">主持人ID: {{ item.mtin_host }}</p>
                      </div>
                    </div>
                    <el-row></el-row>
                    <div class="flex flex-row flex-between">
                      <div class="handle"><el-icon class="pointer" @click="showMeetingDetails(item)"><View /></el-icon></div>
                      <div class="handle"><el-icon class="pointer" @click="onModifyClicked(item)"><Edit /></el-icon></div>
                      <el-popconfirm confirm-button-text="确定" cancel-button-text="取消"
                                     icon="el-icon-info" icon-color="red" title="确定将该会议从您的列表中删除吗"
                                     @confirm="onDelete(item)">
                        <template #reference>
                          <div class="handle"><el-icon class="pointer"><Delete /></el-icon></div>
                        </template>
                      </el-popconfirm>
                    </div>
                  </el-col>
                </el-row>
              </el-card>
              </template>
              <div v-else>
                <el-row></el-row>
                <p>暂无会议安排</p>
              </div>
            </div>
          </div>

          <div class="task">
            <h5 class="task-header text-upercase margin-top-0">今天的会议</h5>
            <div class="task-list-item">
              <template v-if="task.progressing && task.progressing.length">
                <el-card v-for="item in task.progressing" :key="item.id" shadow="hover" class="card">
                  <el-row>
                    <el-col :span="24" style="text-align: left">
                      <div class="flex flex-row flex-between">
                        <span class="badge badge-danger">{{ item.mtin_title }}</span>
                        <small class="text-muted">会议ID：  {{ item.mtin_id }} </small>
                      </div>
                      <p class="name margin-top-1 margin-bottom-1">会议时间：{{ item.mtin_st }}</p>
                      <p class="text-muted margin-bottom-1 ellipsis-text">
                      <span class="margin-right-1"
                      ><el-icon size="19px"><ChatLineSquare /></el-icon>&nbsp;&nbsp;会议简介： {{ item.mtin_ctnt }}</span
                      >
                      </p>
                      <div class="flex flex-row flex-between">
                        <div class="flex flex-row flex-start align-center">
                          <el-avatar size="small" :src="item.avatar? item.avatar: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'"></el-avatar>
                          <p class="name">主持人ID: {{ item.mtin_host }}</p>
                        </div>
                      </div>
                      <el-row></el-row>
                      <div class="flex flex-row flex-between">
                        <div class="handle"><el-icon class="pointer" @click="showMeetingDetails(item)"><View /></el-icon></div>
                        <div class="handle"><el-icon class="pointer" @click="onModifyClicked(item)"><Edit /></el-icon></div>
                        <el-popconfirm confirm-button-text="确定" cancel-button-text="取消"
                                       icon="el-icon-info" icon-color="red" title="确定将该会议从您的列表中删除吗"
                                       @confirm="onDelete(item)">
                          <template #reference>
                            <div class="handle"><el-icon class="pointer"><Delete /></el-icon></div>
                          </template>
                        </el-popconfirm>
                      </div>
                    </el-col>
                  </el-row>
                </el-card>
              </template>
              <div v-else>
                <el-row></el-row>
                <p>暂无会议安排</p>
              </div>
            </div>
          </div>

          <div class="task">
            <h5 class="task-header text-upercase margin-top-0">已完成会议</h5>
            <div class="task-list-item">
              <template v-if="task.passed && task.passed.length">
                <el-card v-for="item in task.passed" :key="item.id" shadow="hover" class="card">
                  <el-row>
                    <el-col :span="24" style="text-align: left">
                      <div class="flex flex-row flex-between">
                        <span class="badge badge-secondary">{{ item.mtin_title }}</span>
                        <small class="text-muted">会议ID：  {{ item.mtin_id }} </small>
                      </div>
                      <p class="name margin-top-1 margin-bottom-1">会议时间：{{ item.mtin_st }}</p>
                      <p class="text-muted margin-bottom-1 ellipsis-text">
                      <span class="margin-right-1"
                      ><el-icon size="19px"><ChatLineSquare /></el-icon>&nbsp;&nbsp;会议简介： {{ item.mtin_ctnt }}</span
                      >
                      </p>
                      <div class="flex flex-row flex-between">
                        <div class="flex flex-row flex-start align-center">
                          <el-avatar size="small" :src="item.avatar? item.avatar: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'"></el-avatar>
                          <p class="name">主持人ID: {{ item.mtin_host }}</p>
                        </div>
                      </div>
                      <el-row></el-row>
                      <div class="flex flex-row flex-between">
                        <div class="handle"><el-icon class="pointer" @click="showMeetingDetails(item)"><View /></el-icon></div>
                        <div class="handle"><el-icon class="pointer" @click="onModifyClicked(item)"><Edit /></el-icon></div>
                        <el-popconfirm confirm-button-text="确定" cancel-button-text="取消"
                                       icon="el-icon-info" icon-color="red" title="确定将该会议从您的列表中删除吗"
                                       @confirm="onDelete(item)">
                          <template #reference>
                            <div class="handle"><el-icon class="pointer"><Delete /></el-icon></div>
                          </template>
                        </el-popconfirm>
                      </div>
                    </el-col>
                  </el-row>
                </el-card>
              </template>
              <div v-else>
                <el-row></el-row>
                <p>暂无会议安排</p>
              </div>
            </div>
          </div>

          <el-dialog v-model="task.detailFormVisible" title="会议详情">
            <el-form :model="task.detailForm">
              <el-form-item label="会议标题&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_title }}
              </el-form-item>
              <el-form-item label="会议内容&nbsp;&nbsp;" :label-width="formLabelWidth">
                <span style=" word-wrap: break-word;
                              word-break: break-word;
                              white-space: normal;">
                 {{ task.detailForm.mtin_ctnt }}
                </span>
              </el-form-item>
              <el-form-item label="会议开始时间&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_st }}
              </el-form-item>
              <el-form-item label="会议长度&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_len }}
              </el-form-item>
              <el-form-item label="会议地点&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_loc }}
              </el-form-item>
              <el-form-item label="会议主持人ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_host }}
              </el-form-item>
              <el-form-item label="会议ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_id }}
              </el-form-item>
              <el-form-item label="会议状态&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_fin }}
              </el-form-item>
              <el-form-item label="会议创建时间&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.mtin_crt }}
              </el-form-item>
              <el-form-item label="会议添加者ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm.adder_id }}
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="task.detailFormVisible = false">确 定</el-button>
            </div>
          </el-dialog>

          <el-dialog v-model="task.modifyFormVisible" title="修改会议详情">
            <el-form :model="task.modifyForm"  ref="activityForm" :rules="rules">
              <el-form-item label="会议标题&nbsp;&nbsp;" :label-width="formLabelWidth" prop="mtin_title">
                <el-input v-model="task.modifyForm.mtin_title" autocomplete="on"></el-input>
              </el-form-item>
              <el-form-item label="会议内容&nbsp;&nbsp;" :label-width="formLabelWidth" prop="mtin_ctnt">
                <el-input v-model="task.modifyForm.mtin_ctnt" autosize type="textarea"/>
              </el-form-item>
              <el-form-item label="会议开始时间&nbsp;&nbsp;" :label-width="formLabelWidth">
                <div>
                  <el-col :span="11">
                    <el-date-picker v-model="task.mtin_st_date"
                                    type="date" placeholder="选择日期" style="width: 100%"
                                    value-format="YYYY-MM-DD"
                    ></el-date-picker>
                  </el-col>
                  <el-col class="line" :span="1">&nbsp;&nbsp;&nbsp;&nbsp;</el-col>
                  <el-col :span="12">
                    <el-time-picker v-model="task.mtin_st_time" placeholder="选择时间" style="width: 100%"
                                    format="HH:mm" value-format="HH:mm"
                    ></el-time-picker>
                  </el-col>
                </div>
              </el-form-item>
              <el-form-item label="会议长度&nbsp;&nbsp;" :label-width="formLabelWidth" prop="mtin_len">
                <el-input v-model="task.modifyForm.mtin_len" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="会议地点&nbsp;&nbsp;" :label-width="formLabelWidth" prop="mtin_loc">
                <el-input v-model="task.modifyForm.mtin_loc" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="会议主持人ID&nbsp;&nbsp;" :label-width="formLabelWidth" prop="mtin_host">
                <el-input v-model="task.modifyForm.mtin_host" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="会议ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.modifyForm.mtin_id }}
              </el-form-item>
              <el-form-item label="会议创建时间&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{task.mtin_crt_date}}&nbsp;&nbsp;{{task.mtin_crt_time}}
              </el-form-item>
              <el-form-item label="为我添加会议者ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{task.modifyForm.adder_id}}
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="task.modifyFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="handleEdit()">确 定</el-button>
            </div>
          </el-dialog>

          <el-dialog v-model="task.addFormVisible" title="为自己添加会议" width="25%">
            <el-form :model="task.search_mtin_id">
              <el-form-item label="请输入会议ID">
                <el-input v-model="task.search_mtin_id" autocomplete="off" />
              </el-form-item>
            </el-form>
            <template #footer>
              <div class="dialog-footer">
                <el-button @click="task.addFormVisible = false">取消</el-button>
                <el-button type="primary" @click="search_by_mtin_id()">
                  查询
                </el-button>
              </div>
            </template>
          </el-dialog>

          <el-dialog v-model="task.detailFormVisible_add" title="会议详情">
            <el-form :model="task.detailFormVisible_add">
              <el-form-item label="会议标题&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_title }}
              </el-form-item>
              <el-form-item label="会议内容&nbsp;&nbsp;" :label-width="formLabelWidth">
                <span style=" word-wrap: break-word;
                              word-break: break-word;
                              white-space: normal;">
                  {{ task.detailForm_add.mtin_ctnt }}
                </span>
              </el-form-item>
              <el-form-item label="会议开始时间&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_st }}
              </el-form-item>
              <el-form-item label="会议长度&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_len }}
              </el-form-item>
              <el-form-item label="会议地点&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_loc }}
              </el-form-item>
              <el-form-item label="会议主持人ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_host }}
              </el-form-item>
              <el-form-item label="会议ID&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_id }}
              </el-form-item>
              <el-form-item label="会议状态&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_fin }}
              </el-form-item>
              <el-form-item label="会议创建时间&nbsp;&nbsp;" :label-width="formLabelWidth">
                {{ task.detailForm_add.mtin_crt }}
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="secondary" @click="task.detailFormVisible_add = false">取消</el-button>
              <el-button type="primary" @click="handleAdd()">确认添加</el-button>
            </div>
          </el-dialog>

          <el-dialog v-model="task.statisticsVisible" title="统计信息">

            <el-card shadow="hover" class="card">
              <p>
                <span><i class="icon-square red"></i> 总会议数</span> <span>{{ task.statistics.total }}</span>
              </p>
                <div class="e-chart" style="height: 201px; width: 100%">
                  <div ref="refAverageSales" style="width: inherit; height: inherit;"></div>
                </div>
                <div class="chart-widget-list">
                  <p>
                    <span><i class="icon-square yellow"></i> 已完成的会议数</span><span>{{ task.passed.length }}</span>
                  </p>
                  <p>
                    <span><i class="icon-square green"></i> 已预约的会议数 </span><span>{{ task.scheduled.length }}</span>
                  </p>
                  <p>
                    <span><i class="icon-square deep-blue"></i> 今天的会议数</span> <span>{{ task.progressing.length }}</span>
                  </p>
                </div>
              </el-card>

            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="task.statisticsVisible = false">确认</el-button>
            </div>
          </el-dialog>


        </div>
      </el-col>
    </el-row>
  </div>
</template>


<script setup lang="ts">

import {onMounted, ref, onUnmounted, reactive, nextTick} from 'vue'
import {
  Operation,
  Suitcase,
  ChatLineSquare,
  View,
  Delete,
  Edit,
  CirclePlus,
  Download,
  Refresh, Odometer, Search, MoreFilled
} from '@element-plus/icons-vue'
import Service from "@/views/Meetings/api/index";
import {ElMessage, ElMessageBox} from "element-plus";
import { useRouter } from 'vue-router'
import permission from '@/directive/permission'
import {useInitPieChart} from "./components/useInitPieCharts";

const refAverageSales = ref<HTMLElement | null>(null)
const router = useRouter()

let eventGuid = 0
/**
 * @description 事件Uid
 */
const createEventId = () => String(eventGuid++)

interface taskType {
  [key: string]: { id: number; priority: number; date: string; title: string; tag: string;
    comments: number; avatar: string; name: string }[]
}

const task = reactive<taskType>({
  scheduled: [
    {
      id: 1,
      priority: 2,
      date: '19jul 2018',
      title: '后台没打开',
      tag: 'web',
      comments: 28,
      avatar: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
      name: 'GeekQiaQia'
    },
  ],
  progressing: [
    {
      id: 1,
      priority: 2,
      date: '19jul 2018',
      title: '后台没打开',
      tag: 'web',
      comments: 22,
      avatar: 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png',
      name: 'GeekQiaQia'
    },
  ],
  passed: [
  ],
  modifyFormVisible: false,
  detailFormVisible: false,
  addFormVisible: false,
  search_mtin_id: 0,
  detailFormVisible_add: false,
  search_field: "none",
  search_key: "",
  statisticsVisible: false,
  statistics: {},

})

onMounted(() => {
  getPersonalMeetingList()
})

const rules = reactive({
  mtin_title: [
    {
      required: true,
      message: '标题不能为空',
      trigger: 'blur',
    },
    {
      validator: (rule, value, callback) => {
        if (value.length > 20) {
          callback(new Error('标题不能超过20个字'));
        } else {
          callback();
        }
      },
      trigger: 'blur',
    },
  ],
  mtin_ctnt: [
    {
      required: true,
      message: '内容不能为空',
      trigger: 'blur',
    },
    {
      validator: (rule, value, callback) => {
        if (value.length > 120) {
          callback(new Error('内容不能超过120个字'));
        } else {
          callback();
        }
      },
      trigger: 'blur',
    },
  ],
  mtin_loc: [
    {
      validator: (rule, value, callback) => {
        if (value && value.length > 20) {
          callback(new Error('地点不能超过20个字'));
        } else {
          callback();
        }
      },
      trigger: 'blur',
    },
  ],
  mtin_host: [
    {
      validator: (rule, value, callback) => {
        if (!/^\d+$/.test(value)) {
          callback(new Error('主持人ID必须是全数字'));
        } else {
          callback();
        }
      },
      trigger: 'blur',
    },
  ],
  mtin_len: [
    {
      validator: (rule, value, callback) => {
        if (value && !/^\d+min$/.test(value)) {
          callback(new Error('会议长度必须以 "min" 结尾'));
        } else {
          callback();
        }
      },
      trigger: 'blur',
    },
  ],
});

const activityForm = ref()

// 组件卸载时销毁实例
onUnmounted(() => {
})

const buttonClickTest = () => {
  console.log("CLicked!")
}


//scope.row
const showMeetingDetails = (row:any) => {
  // console.log("Detail Shows!")
  task.detailForm = row
  // console.log(task.detailForm)
  task.detailFormVisible = true
}

const onShowStatistics = () => {
  task.statisticsVisible = true
  const data = [
    {
      name: "今天的会议",
      value: task.progressing.length
    },
    {
      name: "已预约会议",
      value: task.scheduled.length
    },
    {
      name: "已完成会议",
      value: task.passed.length
    }];
  task.statistics.total = task.progressing.length + task.scheduled.length + task.passed.length
  nextTick(() => {
    if (refAverageSales.value) {
      useInitPieChart(refAverageSales.value, data)
    } else {
      // console.log("refAverageSales not exist!")
    }
  })

}

const onModifyClicked = (item: any) => {
  // console.log("Modify a Meeting!")
  task.modifyForm = item
  task.mtin_st_date = item.mtin_st.split(' ')[0]
  task.mtin_st_time = item.mtin_st.split(' ')[1]
  task.mtin_crt_date = item.mtin_crt.split(' ')[0]
  task.mtin_crt_time = item.mtin_crt.split(' ')[1]
  task.modifyFormVisible = true
}

const onDelete = (item: any) => {
  try {
    Service.deleteMeetingPersonally(item).then((res) => {
      if (res) {
        ElMessage({
          type: 'success',
          message: "删除成功"
        })
        getPersonalMeetingList()
      } else {
        // console.log('deleteMeeting error!')
      }
    });
  } catch (err) {
    ElMessage({
      type: 'warning',
      message: err.message
    })
  }
}

const handleEdit = () => {

  activityForm.value.validate((valid: any): boolean => {
    if (valid) {
      task.modifyFormVisible = false
      let meeting = task.modifyForm
      meeting.mtin_st = [task.mtin_st_date, task.mtin_st_time].join(" ")
      meeting.mtin_crt = [task.mtin_crt_date, task.mtin_crt_time].join(" ")
      try {
        Service.updateMeeting(meeting).then((res) => {
          if (res) {
            ElMessage({
              type: 'success',
              message: "修改成功"
            })
            getPersonalMeetingList()
          } else {
            // console.log('updateMeeting error!')
          }
        });
      } catch (err) {
        ElMessage({
          type: 'warning',
          message: err.message
        })
      }

    } else {
      ElMessage({
        type: 'error',
        message: '请检查您的输入！'
      })
      return false
    }
  })

}

const getPersonalMeetingList = () => {
  // console.log("getPersonalMeetingList exc")
  try {
    Service.getPersonalMeetingList().then((res) => {
      if (res) {
        task.scheduled = res.data[0]
        task.progressing = res.data[1]
        task.passed = res.data[2]
      } else {
        // console.log('getPersonalMeetingList error!')
      }
    });
  } catch (err) {
    ElMessage({
      type: 'warning',
      message: err.message
    })
  }
}

const onCreateMeeting = () => {
  router.replace('/meetings/addMeeting')
}

const onDownload = () => {
  ElMessageBox.confirm('确定要打印为PDF吗', '温馨提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'info'
  }).then(() => {
    // 确认后调用获取 PDF 的方法
    Service.getPDF().then(() => {
      ElMessage({
        type: 'success',
        message: 'PDF 文件正在下载...'
      });
    }).catch(() => {
      ElMessage({
        type: 'error',
        message: '下载失败，请重试'
      });
    });
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '已取消'
    });
  });
}

const onToExcel = () => {
  ElMessageBox.confirm('确定要导出为Excel吗', '温馨提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'info'
  }).then(() => {
    // 确认后调用获取 PDF 的方法
    Service.getExcel().then(() => {
      ElMessage({
        type: 'success',
        message: 'Excel 文件正在下载...'
      });
    }).catch(() => {
      ElMessage({
        type: 'error',
        message: '下载失败，请重试'
      });
    });
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '已取消'
    });
  });
}

const onAddMeeting = () => {
  task.addFormVisible = true
}

const search_by_mtin_id = () => {
  try {
    Service.search_by_mtin_id(task.search_mtin_id).then((res) => {
      if (res.status ===  0) {
        task.detailForm_add = res.data[0]
        task.detailFormVisible_add = true
      } else if (res.status === 1) {
        ElMessage({
          type: 'warning',
          message: "没有找到该会议"
        })
      }
    });
  } catch (err) {
    ElMessage({
      type: 'warning',
      message: err.message
    })
  }
}

const handleAdd = () => {
  const record = task.detailForm_add
  try {
    Service.addMeetingPersonally(record).then((res) => {
      if (res.status ===  0) {
        ElMessage({
          type: 'success',
          message: "成功添加会议"
        })
        task.detailFormVisible_add = false
        task.addFormVisible = false
        getPersonalMeetingList()
      }
    });
  } catch (err) {
    ElMessage({
      type: 'warning',
      message: err.message
    })
  }
}

const onSearchSubmit = () => {
  const record = {
    field: task.search_field,
    key: task.search_key.toString().trim(),
  }
  if (record.field === "none") {
    ElMessage({
      type: 'warning',
      message: "没有选择条件"
    })
    return
  }
  if (record.key === "") {
    ElMessage({
      type: 'warning',
      message: "没有输入搜索内容"
    })
    return
  }
  try {
    Service.searchBy(record).then((res) => {
      // console.log(res)
      if (res.status ===  0) {
        ElMessage({
          type: 'success',
          message: "搜索结果已返回"
        })
        task.scheduled = res.data[0]
        task.progressing = res.data[1]
        task.passed = res.data[2]
      } else if (res.status === 1) {
        ElMessage({
          type: 'warning',
          message: "没有找到符合条件的会议"
        })
      }
    });
  } catch (err) {
    ElMessage({
      type: 'warning',
      message: err.message
    })
  }

}
</script>
