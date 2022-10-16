package com.example.samplelistingapp.repository

import android.content.Context
import com.example.samplelistingapp.data.Page
import com.example.samplelistingapp.utility.util.loadJSONFromAsset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ListRepositoryImp : ListRepository {
    override suspend fun getListData(context: Context?): Page? {
        return withContext(Dispatchers.IO) {
            loadJSONFromAsset(context)?.page
        }

    }

}