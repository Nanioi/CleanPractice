package com.nanioi.cleanpracticeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.nanioi.cleanpracticeapp.databinding.ActivityMainBinding
import com.nanioi.cleanpracticeapp.ui.NyAdapter
import com.nanioi.cleanpracticeapp.ui.NyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: NyViewModel by viewModels()
    private val adapter = NyAdapter()

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val profileId = "PF0000000003777"
    private val schDtt = "202207"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.data = viewModel
        binding.lifecycleOwner = this

        binding.top3Recyclerview.adapter = adapter
        viewModel.getAttendStatus(profileId,schDtt)
        viewModel.getMenuWatchTimeGraph(profileId,schDtt)
        observeState()
    }
    private fun observeState() = viewModel.top3LiveData.observe(this) {
        it?.let{
            adapter.setTop3List(it)
        }
    }

}