<template >
  <div style="text-align: left">
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button @click="dialogVisible = true" icon="el-icon-plus" type="primary" size="mini">添加员工奖惩记录</el-button>
        <el-button size="mini" type="success" @click="loadPersonCfg" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div >
          <el-table
            :data="persons"
            stripe
            border
            v-loading="tableLoading"
            size="mini"
            max-height="250"
            @selection-change="handleSelectionChange"
            style="width: 100%">
            <el-table-column
              fixed
              type="selection"
              width="30"
              align="center">
            </el-table-column>
            <el-table-column
              fixed
              width="150"
              prop="name"
              label="姓名"
              align="center">
            </el-table-column>
            <el-table-column
              width="150"
              prop="workid"
              label="工号"
              align="center">
            </el-table-column>
            <el-table-column
              width="350"
              prop="ecproject"
              label="奖惩项目"
              align="center">
            </el-table-column>
            <el-table-column
              width="150"
              prop="ecdata"
              label="奖惩日期"
              align="center">
            </el-table-column>
            <el-table-column
              width="150"
              prop="ecattribute"
              label="奖惩属性"
              align="center">
            </el-table-column>
            <el-table-column
              width="150"
              prop="ecmoney"
              label="奖惩金额"
              align="center">
            </el-table-column>
            <el-table-column
              width="150"
              prop="ecadmin"
              label="记录人"
              align="center">
            </el-table-column>
            <el-table-column
              width="350"
              prop="ecmarks"
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
                           size="mini" align="center" >编辑
                </el-button>
              </template>
              </el-table-column>
              <el-table-column>
              <template slot-scope="scope">
                <el-button type="danger"  size="mini"
                           @click="handleDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>
              </el-table-column>
            </el-table-column>
          </el-table>
        </div>
        <div style="text-align: left;margin-top: 10px" v-if="persons!=0">
          <el-button type="danger" round size="mini" :disabled="multipleSelection.length==0" @click="deleteAll">批量删除
          </el-button>
        </div>
      </el-main>
    </el-container>
    <div style="text-align: left">
      <el-dialog
        title="添加员工奖惩记录"
        :visible.sync="dialogVisible"
        width="50%"
        @close="emptyPerson"
        :close-on-click-modal="false">
        <div>
          <div style="display: flex;justify-content: flex-start;">
            <el-steps :active="index" direction="vertical">
              <el-step title="员工姓名" size="mini"></el-step>
<!--              index=="0"-->
              <el-step title="员工工号"></el-step>
              <el-step title="奖惩项目"></el-step>
              <el-step title="奖惩日期"></el-step>
              <el-step title="奖惩属性"></el-step>
              <el-step title="奖惩金额"></el-step>
              <el-step title="记录人"></el-step>
              <el-step title="备注"></el-step>
<!--              index=="7"-->
            </el-steps>
            <div style="margin-left: 30px;display: flex;justify-content: center;align-items: center;width: 80%;">
              <div v-show="index==0">
                员工姓名：
                <el-input
                  placeholder="请输入员工姓名..."
                  size="mini"
                  style="width: 200px"
                  type="text"
                  @keyup.enter.native="next"
                  v-model="person.name">
                </el-input>
              </div>
              <div v-show="index==1">
                员工工号：
                <el-input
                  placeholder="请输入员工工作号..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="person.workid">
                </el-input>
              </div>
              <div v-show="index==2">
                奖惩项目：
                <el-input
                  placeholder="请输入奖惩项目..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="person.ecproject">
                </el-input>
              </div>
              <div v-show="index==3">
                奖惩日期：
                <el-input
                  v-model="person.ecdata"
                  type="text"
                  size="mini"
                  style="width: 200px;"
                  placeholder="选择奖惩日期">
                </el-input>
              </div>
              <div v-show="index==4">
                <div>
                  奖惩属性：
                  <el-input
                    placeholder="请输入奖惩属性..."
                    @keyup.enter.native="next"
                    size="mini"
                    style="width: 200px"
                    type="text"
                    v-model="person.ecattribute">
                  </el-input>
                </div>
              </div>
              <div v-show="index==5">
                奖惩金额：
                <el-input
                  placeholder="请输入奖惩金额..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="person.ecmoney">
                </el-input>
              </div>
              <div v-show="index==6">
                <div>
                  记录人：
                  <el-input
                    placeholder="请输入记录人姓名..."
                    @keyup.enter.native="next"
                    size="mini"
                    style="width: 200px"
                    type="text"
                    v-model="person.ecadmin">
                  </el-input>
                </div>
                </div>
              <div v-show="index==7">
                备注：
                <el-input
                  placeholder="备注..."
                  size="mini"
                  @keyup.enter.native="next"
                  style="width: 200px"
                  type="text"
                  v-model="person.ecmarks">
                </el-input>
              </div>
            </div>
          </div>
          <div style="display: flex;align-items: center;justify-content: center;padding: 0px;margin: 0px;">
            <el-button round size="mini" v-if="index!=0" @click="index--">上一步</el-button>
            <el-button type="primary" round size="mini" @click="next" v-text="index==7?'完成':'下一步'"></el-button>
          </div>
        </div>
      </el-dialog>
    </div>
  </div>

</template>
<script>
  export default {
    data() {
      return {
        dialogVisible: false,
        tableLoading: false,
        index: 0,
        persons: [],
        multipleSelection: [],
        person: {
          id: '',
          name: '',
          workid: '',
          ecproject: '',
          ecdata: '',
          ecattribute: '',
          ecmoney: '',
          ecadmin: '',
          ecmarks: ''
        }
      };
    },
    methods: {
      deleteAll(){
        this.$confirm('删除[' + this.multipleSelection.length + ']条记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          var ids = '';
          this.multipleSelection.forEach(row=> {
            ids = ids + row.id + ",";
          })
          this.doDelete(ids);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      handleEdit(index, row) {
        this.dialogVisible = true;
        row.createDate = new Date(row.createDate);
        delete row.allPerson;
        this.person = row;
      },
      handleDelete(index, row) {
        this.$confirm('删除[' + row.name + ']奖惩人, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.doDelete(row.id);
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      doDelete(id){
        var _this = this;
        _this.tableLoading = true;
        this.deleteRequest("/person/ec/rewards/" + id).then(resp=>{
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            var data = resp.data;

            _this.loadPersonCfg();
          }
        });
      },
      next(){
        var _this = this;
        if (this.index == 7) {
          if(this.person.name&&this.person.workid&&this.person.ecproject&&this.person.ecdata&&this.person.ecattribute&&this.person.ecmoney&&this.person.ecadmin&&this.person.ecmarks){
            if (this.person.id) {//更新
              console.log("更新");
              _this.tableLoading = true;
              this.putRequest("/person/ec/rewards", this.person).then(resp=> {
                _this.tableLoading = false;
                if (resp && resp.status == 200) {
                  var data = resp.data;

                  _this.dialogVisible = false;
                  _this.index = 0;
                  _this.loadPersonCfg();
                }
              });
            } else {//添加
              console.log("添加");
              this.$prompt('请再次确认员工姓名', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消'
              }).then(({value}) => {
                console.log("准备发送请求！");
                this.person.name = value;
                this.postRequest("/person/ec/rewards", this.person).then(resp=> {
                  console.log("发送请求！");
                  if (resp && resp.status == 200) {
                    console.log("有了！")
                    var data = resp.data;
                    _this.dialogVisible = false;
                    _this.index = 0;
                    _this.loadPersonCfg();
                  }
                });
              }).catch(() => {
              });
            }
          }else{
            this.$message({type: 'error', message: '字段不能为空!'});
          }
        } else {
          this.index++;
        }
      },
      loadPersonCfg(){
        this.tableLoading = true;
        var _this = this;
        this.getRequest("/person/ec/rewards").then(resp=> {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            _this.persons = resp.data;
          }
        })
        console.log("员工奖惩：成功请求-\"/person/ec/rewards\"！")
      },
      emptyPerson(){
        this.person = {
          id: '',
          name: '',
          workid: '',
          ecproject: '',
          ecdata: '',
          ecattribute: '',
          ecmoney: '',
          ecadmin: '',
          ecmarks: ''
        };
        this.index = 0;
      }
    },
    mounted: function () {
      this.loadPersonCfg();
    }
  };
</script>
<style>
  .el-dialog__body {
    padding-bottom: 10px;
  }
</style>
