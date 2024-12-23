

import axios from "axios";
import qs from "qs"
import {AnyObject} from "./typings/vuecmf";

export default class Model {
    constructor(token: string) {
        axios.defaults.baseURL = import.meta.env.VITE_APP_API_URL
        axios.defaults.timeout = 60000
        //允许跨域携带cookie信息
        axios.defaults.withCredentials = true
        axios.defaults.headers.get['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8'
        axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'

        axios.defaults.headers.common['token'] = token != null ? token : ''

        //请求拦截
        axios.interceptors.request.use((config) => {
            if(config.method === "post" || config.method === "put" || config.method === "delete"){
                // qs序列化
                config.data = qs.parse(config.data)
            }
            return config
        }, (error:AnyObject) => {
            return Promise.reject(error.data.error.message)
        })

        //响应拦截
        axios.interceptors.response.use((config) => {
            if (config.status === 200 || config.status === 204) {
                return Promise.resolve(config);
            } else {
                return Promise.reject(config);
            }
        }, (error:AnyObject) => {
            return Promise.reject(error.data.error.message)
        })

    }

    /**
     * 发起GET请求
     * @param url 请求后端的链接地址
     * @param data 请求参数
     */
    public async get(url: string, data: AnyObject): Promise<AnyObject> {
        return await axios.request({
            method: 'get',
            url,
            data: data,
        })
    }

    /**
     * 发起POST请求
     * @param url 请求后端的链接地址
     * @param data 请求参数
     */
    public async post(url: string, data: AnyObject): Promise<AnyObject> {
        return await axios.request({
            method: 'post',
            url,
            data: data,
        })
    }

}
