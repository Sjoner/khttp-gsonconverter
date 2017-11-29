package com.sjoner.http.converter

import com.google.gson.Gson
import okhttp3.ResponseBody
import java.lang.reflect.Type

class GsonResponseConverter:Converter<ResponseBody?,Any> {
    override fun convert(value: ResponseBody?, returnType: Type): Any {
        val gson = Gson()
        val json = value?.string()
        println("returnType = ${returnType.typeName}")
        if (json != null) {
            return gson.fromJson(json, returnType)
        } else {
            return Any()
        }
    }
}