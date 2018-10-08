package com.android.arch.helper

class ResourcesResponse<T>(val status: StatusConstant, val data: T?, val message: String?) {

    override fun equals(any: Any?): Boolean {
        if (this === any) {
            return true
        }
        if (any == null || javaClass != any.javaClass) {
            return false
        }

        val resource = any as ResourcesResponse<*>?

        if (status != resource!!.status) {
            return false
        }
        if (if (message != null) message != resource.message else resource.message != null) {
            return false
        }
        return if (data != null) data == resource.data else resource.data == null
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + (message?.hashCode() ?: 0)
        result = 31 * result + (data?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\''.toString() +
                ", data=" + data +
                '}'.toString()
    }

    companion object {

        fun <T> success(data: T?): ResourcesResponse<T> {
            return ResourcesResponse(StatusConstant.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ResourcesResponse<T> {
            return ResourcesResponse(StatusConstant.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ResourcesResponse<T> {
            return ResourcesResponse(StatusConstant.LOADING, data, null)
        }
    }
}
