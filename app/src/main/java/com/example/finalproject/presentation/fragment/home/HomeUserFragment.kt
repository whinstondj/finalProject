package com.example.finalproject.presentation.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finalproject.base.BaseExtraData
import com.example.finalproject.base.BaseFragment
import com.example.finalproject.databinding.FragmentHomeUserBinding

class HomeUserFragment : BaseFragment<HomeUserState, HomeUserViewModel, FragmentHomeUserBinding>() {

    override val viewModelClass: Class<HomeUserViewModel> = HomeUserViewModel::class.java

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeUserBinding = FragmentHomeUserBinding::inflate

    override fun setupView(viewModel: HomeUserViewModel) {

    }

    override fun onNormal(data: HomeUserState) {

    }

    override fun onLoading(dataLoading: BaseExtraData?) {

    }

    override fun onError(dataError: Throwable) {

    }
}