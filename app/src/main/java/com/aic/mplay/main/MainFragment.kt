package com.aic.mplay.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aic.mplay.MainViewModel
import com.aic.mplay.databinding.FragmentMainBinding
import com.bumptech.glide.Glide

class MainFragment: Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var handler: Handler
    private val autoNextDelay: Long = 3000

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        observerViewModel()
    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun observerViewModel(){
        handler = Handler(Looper.getMainLooper())


        viewModel.player1.observe(viewLifecycleOwner) { player ->
            binding.exoPlayerView1.player = player
        }

        viewModel.player2.observe(viewLifecycleOwner) { player ->
            binding.exoPlayerView2.player = player
        }

        viewModel.player3.observe(viewLifecycleOwner) { player ->
            binding.exoPlayerView3.player = player
        }

        viewModel.player4.observe(viewLifecycleOwner) { player ->
            binding.exoPlayerView4.player = player
        }

        viewModel.player5.observe(viewLifecycleOwner) { player ->
            binding.exoPlayerView5.player = player
        }

        viewModel.player6.observe(viewLifecycleOwner) { player ->
            binding.exoPlayerView6.player = player
        }


        viewModel.currentImageUrl.observe(viewLifecycleOwner, Observer { imageUrl ->
            loadImage(imageUrl)
        })

        startAutoNext()


        val webViews = listOf(binding.webView1, binding.webView2, binding.webView3, binding.webView4, binding.webView5, binding.webView6)

        viewModel.webUrls.observe(viewLifecycleOwner, Observer { urls ->
            for (i in webViews.indices) {
                setupWebView(webViews[i], urls[i])
            }
        })
    }

    private fun loadImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .into(binding.image1)

        Glide.with(this)
            .load(imageUrl)
            .into(binding.image2)

        Glide.with(this)
            .load(imageUrl)
            .into(binding.image3)

        Glide.with(this)
            .load(imageUrl)
            .into(binding.image4)

        Glide.with(this)
            .load(imageUrl)
            .into(binding.image5)

        Glide.with(this)
            .load(imageUrl)
            .into(binding.image6)
    }

    private fun startAutoNext() {
        handler.postDelayed({
            viewModel.getNextImageUrl()
            startAutoNext()
        }, autoNextDelay)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacksAndMessages(null)
        _binding = null

    }


    private fun setupWebView(webView: WebView, url: String) {
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }


}