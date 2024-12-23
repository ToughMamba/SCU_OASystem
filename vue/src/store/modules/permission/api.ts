import request from '@/utils/request'

const permissionApi = {
  queryAuthedPermission: '/api/auth/permission/routes',
  queryPermissions: '/api/auth/permission/permissions'
}

class Service {
  /**
   * @description POST 查询授权菜单权限
   */
  static postAuthPermission(data: any) {
    return request({
      url: 'http://localhost:8080/api/auth/permission/routes',//permissionApi.queryAuthedPermission,
      method: 'POST',
      json: true,
      data
    }).then((res) => {
      if (res.status === 0) {
        return Promise.resolve(res)
      }
      return Promise.reject(res)
    })
  }

  /**
   * @description POST 查询授权菜单权限
   */
  static postPermissions(data: any) {
    return request({
      url: permissionApi.queryPermissions,//'http://localhost:8080/api/auth/permission/permissions'
      method: 'POST',
      json: true,
      data
    }).then((res) => {
      if (res.status === 0) {
        return Promise.resolve(res)
      }
      return Promise.reject(res)
    })
  }
}
export default Service
