package com.example.countryapp.ui.viewmodel.countrydetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.countryapp.R
import com.example.countryapp.domain.model.Country
import com.example.countryapp.domain.model.HorizontalPagerContent
import com.example.countryapp.ui.theme.GreyIcon
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


/**
 * return@label(func/lambda)
 * return@launch ->stop the execution of the coroutine and return control to the caller, the launch function.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CountryImagePaging(countryDetail: Country, modifier: Modifier) {

    val pagerState = rememberPagerState()
    val countryPages = listOf(
        HorizontalPagerContent(countryDetail.flags),
        HorizontalPagerContent(countryDetail.coatOfArms ?: ""),
    )

    val scope = rememberCoroutineScope()
    Box(
        modifier = modifier
            .size(width = 400.dp, height = 190.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        HorizontalPager(
            count = countryPages.size,
            state = pagerState,
            modifier = modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) { page ->
            Box(modifier = Modifier.fillMaxSize()) {
                Surface(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = countryPages[page].imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }

        //<
        PagerSlideButton(
            modifier = modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .clickable {
                    scope.launch {
                        if (pagerState.currentPage == 0) {
                            return@launch
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
            icon = R.drawable.ic_arrow_back_ios
        )

        //>
        PagerSlideButton(
            modifier = modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .clickable {
                    scope.launch {
                        if (pagerState.currentPage == countryPages.lastIndex) {
                            return@launch
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
            icon = R.drawable.ic_arrow_forward_ios
        )

        //ooo
        HorizontalPagerIndicator(
            pagerState = pagerState,
            activeColor = Color.White,
            inactiveColor = Color.LightGray,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}


@Composable
fun PagerSlideButton(modifier: Modifier = Modifier, icon: Int) {
    Surface(
        modifier = modifier
            .size(32.dp)
            .clip(CircleShape),
        color = GreyIcon
    ) {
        Box {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "arrow icon",
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )
        }
    }

}
