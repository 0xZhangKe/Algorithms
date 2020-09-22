package com.zhangke.algorithms

import java.lang.Error

/**
 * Created by ZhangKe on 2020/4/28.
 */
class Assert {

    companion object {

        @JvmStatic
        fun assertEquals(first: Int, second: Int) {
            if (first != second) throw AssertEqualsError("$first != $second")
        }
    }
}

class AssertEqualsError(_message: String? = null) : Error(_message)