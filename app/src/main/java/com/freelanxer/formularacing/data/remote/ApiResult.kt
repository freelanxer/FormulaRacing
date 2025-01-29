package com.freelanxer.formularacing.data.remote

sealed class ApiResult<T>(
    val data: T? = null,
    val exception: Throwable? = null,
) {
    class Success<T>(result: T?) : ApiResult<T>(result)
    class Fail<T>(exception: Throwable?) : ApiResult<T>(data = null, exception = exception)
}