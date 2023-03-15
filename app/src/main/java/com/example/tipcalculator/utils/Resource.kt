package com.example.tipcalculator.utils

import com.example.tipcalculator.data.model.NewsListModel

data class Resource<out T>(var status: Status, val data : T?, val message : String?){

    companion object{

        fun <T> success(data : T) : Resource<NewsListModel> {
            return Resource(Status.Success,data as NewsListModel,null)
        }

        fun <T> error(data : T?,message : String?) : Resource<T>{
            return Resource(Status.Error,data,message)
        }

        fun <T> loading(data : T?) : Resource<T>{
            return Resource(Status.Loading,data,null)
        }
    }
}
