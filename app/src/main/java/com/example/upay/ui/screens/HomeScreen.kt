package com.example.upay.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.upay.R
import kotlinx.coroutines.delay

// Colors
val UpayYello = Color(0xFFFFCC00)
val UpayDarkBlue = Color(0xFF0D47A1)
val UpayYellow30Percent = Color(0xFFFFFDD0)

// Data class
data class ServiceItem(
    val name: String,
    val icon: ImageVector,
    val iconTint: Color = UpayDarkBlue
)

// Main services
val mainServices = listOf(
    ServiceItem("সেন্ড মানি", Icons.AutoMirrored.Default.Send),
    ServiceItem("মোবাইল রিচার্জ", Icons.Default.PhoneAndroid),
    ServiceItem("ক্যাশ আউট", Icons.Default.MonetizationOn),
    ServiceItem("পেমেন্ট", Icons.Default.ShoppingCart),
    ServiceItem("ট্রাফিক ফাইন", Icons.Default.DirectionsCar),
    ServiceItem("ইউটিলিটি বিল", Icons.Default.Lightbulb),
    ServiceItem("পে বিল", Icons.Default.Receipt),
    ServiceItem("আরো", Icons.Default.MoreHoriz)
)

// Other services
val otherServices = listOf(
    ServiceItem("পেওনিয়ার", Icons.Default.AccountBalanceWallet),
    ServiceItem("রেফার ও আর্ন", Icons.Default.GroupAdd),
    ServiceItem("ইন্সুরেন্স", Icons.Default.Security),
    ServiceItem("ডোনেশন", Icons.Default.VolunteerActivism),
    ServiceItem("বিমান টিকেট", Icons.Default.Flight),
    ServiceItem("রেল টিকেট", Icons.Default.Train),
    ServiceItem("ফিস", Icons.Default.AttachMoney),
    ServiceItem("অন্যান্য", Icons.Default.AddCircleOutline)
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    

    Scaffold(
        topBar = { TopSection() },
        bottomBar = { UpayBottomNavigationBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { MainServicesSection(services = mainServices) }
            item { BannerSection() }
            item {
                OtherServicesSection(services = otherServices)
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun TopSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(UpayYello)
            .statusBarsPadding()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(2f)
                .size(70.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .weight(5.5f)
                .padding(8.dp)
        ) {
            Text(
                text = "MD KAJAM-ALL KORAISH",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "01934983451",
                fontSize = 12.sp,
                color = Color.DarkGray
            )
        }

        Button(
            onClick = { },
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = UpayDarkBlue),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
            modifier = Modifier
                .weight(2.5f)
                .padding(2.dp)
        ) {
            Text(
                text = "ব্যালেন্স",
                fontSize = 12.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MainServicesSection(services: List<ServiceItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 8.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        userScrollEnabled = false
    ) {
        items(services) { item ->
            ServiceItemView(item = item)
        }
    }
}

@Composable
fun ServiceItemView(item: ServiceItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 4.dp)
            .clickable { }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.name,
                tint = item.iconTint,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.name,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.width(70.dp),
            lineHeight = 14.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BannerSection() {
    val banners = listOf(
        R.drawable.banner_1,
        R.drawable.banner_2,
        R.drawable.banner_3,
        R.drawable.banner_4,
        R.drawable.banner_5
    )

    val pagerState = rememberPagerState(initialPage = 0) {
        banners.size
    }

    //auto slide after 3 second
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextPage = (pagerState.currentPage + 1) % banners.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        // Banner slider
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) { page ->
            Image(
                painter = painterResource(id = banners[page]),
                contentDescription = "Banner",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Dots indicator
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(banners.size) { index ->
                Box(
                    modifier = Modifier

                        .padding(3.dp)
                        .size(if (index == pagerState.currentPage) 10.dp else 6.dp)
                        .clip(CircleShape)
                        .background(
                            if (index == pagerState.currentPage) Color(0xFF0D47A1) // active color
                            else Color.LightGray // inactive color
                        )
                )
            }
        }
    }
}

@Composable
fun OtherServicesSection(services: List<ServiceItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 8.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        userScrollEnabled = false
    ) {
        items(services) { item ->
            ServiceItemView(item = item)
        }
    }
}

@Composable
fun UpayBottomNavigationBar() {
    val items = listOf(
        "হোম" to Icons.Default.Home,
        "হিস্টরি" to Icons.Default.History,
        "অ্যাকাউন্ট" to Icons.Default.AccountBalanceWallet,
        "ইনবক্স" to Icons.Default.Inbox,
        "আরো" to Icons.Default.MoreHoriz
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(UpayYellow30Percent)
            .padding(vertical = 4.dp)
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { (label, icon) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .clickable { }
                    .padding(vertical = 2.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = UpayDarkBlue,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = label,
                    fontSize = 12.sp,
                    color = UpayDarkBlue
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
