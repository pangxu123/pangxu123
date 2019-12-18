<template >
  <div style="text-align: left">
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button @click="dialogVisible = true" icon="el-icon-plus" type="primary" size="mini">功能暂定</el-button>
        <el-button size="mini" type="success" @click="loadPersonCfg" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div style="text-align: center">
          调薪候选人数据统计表
        </div>
        <div >
          <el-table
            :data="personsalaries"
            stripe
            border
            v-loading="tableLoading"
            size="mini"
            @selection-change=""
            style="width: 100%">
            <el-table-column
              type="selection"
              fixed
              width="30"
              align="center">
            </el-table-column>
            <el-table-column
              width="150"
              prop="name"
              label="姓名"
              align="center">
            </el-table-column>
            <el-table-column
              label="10月"
              align="center">
              <el-table-column
                width="120"
                prop="ten_throughput"
                label="通过量"
                align="center">
              </el-table-column>
              <el-table-column
                width="120"
                prop="ten_score"
                label="绩效得分"
                align="center">
              </el-table-column>
            </el-table-column>
            <el-table-column
              label="11月"
              align="center">
              <el-table-column
                width="120"
                prop="eleven_throughput"
                label="通过量"
                align="center">
              </el-table-column>
              <el-table-column
                width="120"
                prop="eleven_score"
                label="绩效得分"
                align="center">
              </el-table-column>
            </el-table-column>
            <el-table-column
              label="12月"
              align="center">
              <el-table-column
                width="120"
                prop="twelve_throughput"
                label="通过量"
                align="center">
              </el-table-column>
              <el-table-column
                width="120"
                prop="twelve_score"
                label="绩效得分"
                align="center">
              </el-table-column>
            </el-table-column>
            <el-table-column
              label="1月"
              align="center">
              <el-table-column
                width="120"
                prop="one_throughput"
                label="通过量"
                align="center">
              </el-table-column>
              <el-table-column
                width="120"
                prop="one_number"
                label="邮件处理量"
                align="center">
              </el-table-column>
              <el-table-column
                width="120"
                prop="one_score"
                label="绩效得分"
                align="center">
              </el-table-column>
            </el-table-column>
            <el-table-column
              label="2月"
              align="center">
              <el-table-column
                width="120"
                prop="two_throughput"
                label="通过量"
                align="center">
              </el-table-column>
              <el-table-column
                width="120"
                prop="two_number"
                label="邮件处理量"
                align="center">
              </el-table-column>
            </el-table-column>
            <el-table-column
              width="120"
              prop="remarks"
              label="备注"
              align="center">
            </el-table-column>
            <el-table-column
              width="160"
              fixed="right"
              label="操作"
              align="center">
              <el-table-column>
                <template slot-scope="scope">
                  <el-button @click="handleEdit(scope.$index, scope.row)"
                             size="mini" align="center" >通过
                  </el-button>
                </template>
              </el-table-column>
              <el-table-column>
                <template slot-scope="scope">
                  <el-button type="danger"  size="mini"
                             @click="handleDelete(scope.$index, scope.row)">驳回
                  </el-button>
                </template>
              </el-table-column>
            </el-table-column>
          </el-table>
        </div>
      </el-main>

      <el-dialog
        :datatype="personsalaries"
        stripe
        title="添加员工调薪记录"
        :visible.sync="dialogVisible"
        v-loading="tableLoading"
        width="50%"
        :close-on-click-modal="false">
        <div>
          <h1>弹出框</h1>
        </div>
      </el-dialog>

    </el-container>

  </div>

</template>
<script>
  export default {
    data() {
      return {
        dialogVisible: false,
        tableLoading: false,
        index: 0,
        personsalaries: [],
        multipleSelection: [],
        personsalary: {
          id: '',
          ten_throughput: '',
          ten_score: '',
          eleven_throughput: '',
          eleven_score: '',
          twelve_throughput: '',
          twelve_throughput: '',
          one_throughput: '',
          one_number: '',
          one_score: '',
          two_throughput: '',
          two_number: '',
          remarks:''
        }
      };
    },
    methods: {
      loadPersonCfg(){
        this.tableLoading = true;
        var _this = this;
        this.getRequest("/person/salary/salaries").then(resp=> {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            _this.personsalaries = resp.data;
          }
        })
        console.log("员工调薪：成功请求-\"/person/salary/salaries\"！")
      },
    },
    mounted: function () {
      this.loadPersonCfg();
    }
  }
</script>
