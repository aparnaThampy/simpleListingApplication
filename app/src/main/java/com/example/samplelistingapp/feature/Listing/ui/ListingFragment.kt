package com.example.samplelistingapp.feature.Listing.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.samplelistingapp.R
import com.example.samplelistingapp.feature.Listing.ListingViewModel
import com.example.samplelistingapp.feature.Listing.adaptor.CourseGVAdapter
import com.example.samplelistingapp.utility.ExtensionsUtil.gridManager
import com.example.samplelistingapp.utility.util.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*


@AndroidEntryPoint
class ListingFragment : Fragment() {

    companion object {
        fun newInstance() = ListingFragment()
    }

    private var adapter: CourseGVAdapter? = null
    private val viewModel: ListingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        viewModel.getList(context)
    }

    private fun initView() {
        initRecyclerView()
        initSearchListener()
    }

    private fun initRecyclerView() {
        recyclerView.gridManager()
        adapter = context?.let { CourseGVAdapter() }
        recyclerView.adapter = adapter
    }

    private fun initSearchListener() {
        searchView.setOnCloseListener {
            viewModel.setTotalListItem()
            return@setOnCloseListener false
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getSearchList(query)
                searchView.clearFocus();
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (TextUtils.isEmpty(newText))
                    viewModel.setTotalListItem()
                return false
            }
        })
    }

    private fun initObserver() {
        viewModel.listItem.observe(viewLifecycleOwner) { item ->
            adapter?.updateList(item)
        }
        viewModel.listTitle.observe(viewLifecycleOwner) { item ->
            titleTv.text = item
        }
        viewModel.toastText.observe(viewLifecycleOwner) { item ->
            showToast(item, context)
        }
        viewModel.searchListItem.observe(viewLifecycleOwner) { item ->
            adapter?.updateList(item)
        }
    }
}

