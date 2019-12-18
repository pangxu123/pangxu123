<template >
  <div style="text-align: left">
    <el-container>
      <el-header style="display: flex;justify-content: space-between;align-items: center;padding-left: 0px">
        <el-button @click="dialogVisible = true" icon="el-icon-plus" type="primary" size="mini">添加培训记录</el-button>
        <el-button size="mini" type="success" @click="loadPersonCfg" icon="el-icon-refresh"></el-button>
      </el-header>
      <el-main style="padding-left: 0px;padding-top: 0px">
        <div >
          <el-table
            :data="persontrs"
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
              width="120"
              fixed
              prop="id"
              label="培训序号"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              fixed
              prop="tr_contents"
              label="培训内容"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_category"
              label="培训内别"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_lead_department"
              label="牵头承办部门"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_assistance_department"
              label="协助承办部门"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_object"
              label="培训对象"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_form"
              label="培训形式"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_lecturer"
              label="培训讲师"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_material"
              label="培训教材"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_place"
              label="培训地点"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_duration"
              label="培训时长"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_method"
              label="考核方式"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_remarks"
              label="备注"
              align="center">
            </el-table-column>
            <el-table-column
              width="120"
              prop="tr_budget_mode"
              label="预算方式"
              align="center">
            </el-table-column>
            <el-table-column
              width="160"
              fixed="right"
              align="center"
              label="操作">
              <el-table-column
                align="center"
                label="编辑">
              <template slot-scope="scope">
                <el-button @click="handleEdit(scope.$index, scope.row)"
                           size="mini">编辑
                </el-button>
              </template>
              </el-table-column>
              <el-table-column
                align="center"
                label="删除">
                <template slot-scope="scope">
                <el-button type="danger"  size="mini"
                           @click="handleDelete(scope.$index, scope.row)">删除
                </el-button>
              </template>
              </el-table-column>

            </el-table-column>
          </el-table>
        </div>
<!--        <div style="text-align: left;margin-top: 10px" v-if="persontrs!=0">-->
<!--          <el-button type="danger" round size="mini" :disabled="multipleSelection.length==0" @click="deleteAll">批量删除-->
<!--          </el-button>-->
<!--        </div>-->
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
              <!--              index=="0"-->
              <el-step title="培训内容" size="mini"></el-step>
              <el-step title="培训类别"></el-step>
              <el-step title="培训牵头部门"></el-step>
              <el-step title="培训协助部门"></el-step>
              <el-step title="培训对象"></el-step>
              <el-step title="培训形式"></el-step>
              <el-step title="培训讲师"></el-step>
              <el-step title="培训教材"></el-step>
              <el-step title="培训地点"></el-step>
              <el-step title="培训时长"></el-step>
              <el-step title="培训考核方式"></el-step>
              <el-step title="备注"></el-step>
              <el-step title="预算方式"></el-step>
              <!--              index=="12"-->
            </el-steps>
            <div style="margin-left: 30px;display: flex;justify-content: center;align-items: center;width: 80%;">
              <div v-show="index==0">
                培训内容：
                <el-input
                  placeholder="请输入员工培训内容..."
                  size="mini"
                  style="width: 200px"
                  type="text"
                  @keyup.enter.native="next"
                  v-model="persontr.tr_contents">
                </el-input>
              </div>
              <div v-show="index==1">
                培训类别：
                <el-input
                  placeholder="请输入员工培训类别..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_category">
                </el-input>
              </div>
              <div v-show="index==2">
                牵头承办部门：
                <el-input
                  placeholder="请输入此次培训牵头承办部门..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_lead_department">
                </el-input>
              </div>
              <div v-show="index==3">
                协助承办部门：
                <el-input
                  v-model="persontr.tr_assistance_department"
                  type="text"
                  size="mini"
                  style="width: 200px;"
                  placeholder="请输入此次培训协助承办部门...">
                </el-input>
              </div>
              <div v-show="index==4">
                <div>
                  培训对象：
                  <el-input
                    placeholder="请输入此次培训对象..."
                    @keyup.enter.native="next"
                    size="mini"
                    style="width: 200px"
                    type="text"
                    v-model="persontr.tr_object">
                  </el-input>
                </div>
              </div>
              <div v-show="index==5">
                培训形式：
                <el-input
                  placeholder="请输入此次培训形式..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_form">
                </el-input>
              </div>
              <div v-show="index==6">
                培训讲师：
                <el-input
                  placeholder="请输入此次培训讲师..."
                  @keyup.enter.native="next"
                  size="mini"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_lecturer">
                </el-input>
              </div>
              <div v-show="index==7">
                <div>
                  培训教材：
                  <el-input
                    placeholder="请输入此次培训教材..."
                    @keyup.enter.native="next"
                    size="mini"
                    style="width: 200px"
                    type="text"
                    v-model="persontr.tr_material">
                  </el-input>
                </div>
              </div>
              <div v-show="index==8">
                培训地点：
                <el-input
                  placeholder="请输入此次培训的地点..."
                  size="mini"
                  @keyup.enter.native="next"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_place">
                </el-input>
              </div>
              <div v-show="index==9">
                培训时长：
                <el-input
                  placeholder="请输入此次培训的培训时长..."
                  size="mini"
                  @keyup.enter.native="next"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_duration">
                </el-input>
              </div>
              <div v-show="index==10">
                考核方式：
                <el-input
                  placeholder="请输入此次培训的考核方式..."
                  size="mini"
                  @keyup.enter.native="next"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_method">
                </el-input>
              </div>
              <div v-show="index==11">
                备注：
                <el-input
                  placeholder="备注..."
                  size="mini"
                  @keyup.enter.native="next"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_remarks">
                </el-input>
              </div>
              <div v-show="index==12">
                预算方式：
                <el-input
                  placeholder="请输入此次培训的预算方式..."
                  size="mini"
                  @keyup.enter.native="next"
                  style="width: 200px"
                  type="text"
                  v-model="persontr.tr_budget_mode">
                </el-input>
              </div>
            </div>
          </div>
          <div style="display: flex;align-items: center;justify-content: center;padding: 0px;margin: 0px;">
            <el-button round size="mini" v-if="index!=0" @click="index--">上一步</el-button>
            <el-button type="primary" round size="mini" @click="next" v-text="index==12?'完成':'下一步'"></el-button>
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
      persontrs: [],
      multipleSelection: [],
      persontr: {
        id:'',
        tr_contents: '',
        tr_category: '',
        tr_lead_department: '',
        tr_assistance_department: '',
        tr_object: '',
        tr_form: '',
        tr_lecturer: '',
        tr_material: '',
        tr_place: '',
        tr_duration:'',
        tr_method:'',
        tr_remarks:'',
        tr_budget_mode:''
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
        delete row.allPersontr;
        this.persontr = row;
      },
      handleDelete(index, row) {
        this.$confirm('删除该培训记录, 是否继续?', '提示', {
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
        this.deleteRequest("/person/tr/train/" + id).then(resp=>{
          _this.tableLoading = false;
          if (resp && resp.status == 200) {

            _this.loadPersonCfg();
          }
        });
      },
      next(){
        var _this = this;
        if (this.index == 12) {
          if(this.persontr.tr_contents&&this.persontr.tr_category&&this.persontr.tr_lead_department&&this.persontr.tr_assistance_department&&this.persontr.tr_object&&this.persontr.tr_form&&this.persontr.tr_lecturer&&this.persontr.tr_material&&this.persontr.tr_place&&this.persontr.tr_duration&&this.persontr.tr_method&&this.persontr.tr_remarks&&this.persontr.tr_budget_mode){
            if (this.persontr.id) {//更新
              console.log("更新");
              _this.tableLoading = true;
              this.putRequest("/person/tr/train", this.persontr).then(resp=> {
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
              console.log(this.persontr);
              this.$prompt('请再次确认员工姓名', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
              }).then(({value}) => {
                console.log("准备发送请求！");
                this.persontr.tr_contents = value;
                this.postRequest("/person/tr/train", this.persontr).then(resp=> {
                  console.log("发送请求！");
                  if (resp && resp.status == 200) {
                     console.log("有了！")
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
        this.getRequest("/person/tr/train").then(resp=> {
          _this.tableLoading = false;
          if (resp && resp.status == 200) {
            _this.persontrs = resp.data;
          }
        })
        console.log("员工培训：成功请求-\"/person/tr/train\"！")
      },
      emptyPerson(){
        this.persontr = {
          id: '',
          tr_contents: '',
          tr_category: '',
          tr_lead_department: '',
          tr_assistance_department: '',
          tr_object: '',
          tr_form: '',
          tr_lecturer: '',
          tr_material: '',
          tr_place:'',
          tr_duration:'',
          tr_method:'',
          tr_remarks:'',
          tr_budget_mode:''
        };
        this.index = 0;
      }
    },
    mounted: function () {
      this.loadPersonCfg();
    }
  }
</script>
