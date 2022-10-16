package com.example.samplelistingapp.repository

import android.content.Context
import com.example.samplelistingapp.data.Page

interface ListRepository {
    suspend fun getListData(context: Context?): Page?
}