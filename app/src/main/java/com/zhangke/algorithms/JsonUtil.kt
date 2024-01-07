package com.zhangke.algorithms

import com.google.gson.Gson
import com.google.gson.GsonBuilder

val sharedGson: Gson = GsonBuilder()
    .create()