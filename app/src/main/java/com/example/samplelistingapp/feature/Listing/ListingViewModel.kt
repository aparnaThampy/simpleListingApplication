package com.example.samplelistingapp.feature.Listing

import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplelistingapp.R
import com.example.samplelistingapp.data.Content
import com.example.samplelistingapp.repository.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val listRepository: ListRepository
) : ViewModel() {
    val listItem = MutableLiveData<List<Content>>()
    val toastText = MutableLiveData<Int>()
    val searchListItem = MutableLiveData<List<Content>>()
    val listTitle = MutableLiveData<String>()


    internal fun getList(context: Context?) {
        viewModelScope.launch {
            val listData = listRepository.getListData(context)
            setTotalListItem(listData?.contentItems?.content)
            listTitle.value = listData?.title

        }
    }

    internal fun setTotalListItem(listData: List<Content>? = listItem.value) {
        listItem.value = listData ?: listItem.value
    }

    internal fun getSearchList(searchText: String?) {
        if (TextUtils.isEmpty(searchText)) {
            setSearchText()
            return
        }
        val filter = listItem.value?.filter {
            it.name.contains(searchText.toString(), true)
        }
        setSearchText(filter)
        if (filter.isNullOrEmpty()) {
            toastText.value = R.string.no_matach_found_search_text
        }
    }

    private fun setSearchText(filter: List<Content>? = listOf()) {
        searchListItem.value = filter ?: listOf()
    }
}