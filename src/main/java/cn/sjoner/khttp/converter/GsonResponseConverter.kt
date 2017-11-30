package cn.sjoner.khttp.converter

import com.google.gson.Gson
import okhttp3.ResponseBody
import java.lang.reflect.Type

class GsonResponseConverter:Converter<ResponseBody?,Any> {
    override fun convert(value: ResponseBody?, type: Type): Any {
        val gson = Gson()
        val json = value?.string()
        if (json != null) {
            return gson.fromJson(json, type)
        } else {
            return Class.forName((type as Class<*>).name).newInstance()
        }
    }
}