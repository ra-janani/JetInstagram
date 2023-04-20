package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*


import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R

import com.vipulasri.jetinstagram.data.ImageWithText

@Composable
fun ProfilePage(){
    var selectedTabIndex by remember{
        mutableStateOf(0)
    }
    Column(modifier= Modifier.fillMaxSize()){
    TopBar(name = "Janani Rajendran",modifier=Modifier.padding(20.dp))
        Spacer(modifier=Modifier.height(4.dp))
        ProfileSection()
        ProfileDesc(displayName = "Janani", description = "Lives in London")
        Spacer(modifier=Modifier.height(25.dp))
        ButtonSection(modifier=Modifier.fillMaxWidth())
        Spacer(modifier=Modifier.height(25.dp))
        HighLightSection(highlights = listOf(
            ImageWithText(
                image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab1_inversions),
                text="Inversions"
            ),
            ImageWithText(
                image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab2_quick_yoga),
                text="YOGA"
            ),
            ImageWithText(
                image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab3_stretching),
                text="Stretch"
            ),
            ImageWithText(
                image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab4_tabata),
                text="Tabata"
            ),
        ),
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier=Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ic_grid),
                    text="Posts"
                ),
                ImageWithText(
                    image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ic_grid),
                    text="Posts"
                ),
                ImageWithText(
                    image= painterResource(id =com.vipulasri.jetinstagram. R.drawable.ic_grid),
                    text="Posts"
                ),
                ImageWithText(
                    image= painterResource(id = com.vipulasri.jetinstagram.R.drawable.ic_grid),
                    text="Posts"
                ),
        )
        )   {
            selectedTabIndex=it
        }
        when(selectedTabIndex){
            0-> PostSection(
                    posts = listOf(
                        painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab1_inversions),
                        painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab2_quick_yoga),
                        painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab3_stretching),
                        painterResource(id =com.vipulasri.jetinstagram. R.drawable.ab4_tabata),
                        painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab1_inversions),
                        painterResource(id = com.vipulasri.jetinstagram.R.drawable.ab2_quick_yoga),
                    ),
                modifier=Modifier.fillMaxWidth()
            )
        }

    }
}

@Composable
fun TopBar(
    name:String,
    modifier:Modifier=Modifier
){
    Row(verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement =Arrangement.SpaceAround,
        modifier=Modifier.fillMaxWidth()
    ){
        Icon(imageVector= Icons.Default.ArrowBack,
            contentDescription="Back",
            tint= Color.Black,
            modifier=Modifier.size(24.dp)
            )
        Text(
            text=name,
            overflow=TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter=painterResource(id=com.vipulasri.jetinstagram.R.drawable.ic_bell),
            contentDescription="Back",
            tint= Color.Black,
            modifier=Modifier.size(24.dp)
        )
        Icon(
            painter=painterResource(id=com.vipulasri.jetinstagram.R.drawable.ic_menu),
            contentDescription="Back",
            tint= Color.Black,
            modifier=Modifier.size(24.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier:Modifier=Modifier
){
    Column(modifier=modifier.fillMaxWidth()){
        Row(verticalAlignment = Alignment.CenterVertically,
        modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp))
        {
            RoundImage(
                image = painterResource(id=com.vipulasri.jetinstagram.R.drawable.profile_img),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier=Modifier.width(16.dp))
            Status(modifier=Modifier.weight(7f))
        }
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier:Modifier=Modifier
){
    Image(
        painter=image,
        contentDescription=null,
        contentScale=ContentScale.FillBounds,
        modifier= modifier
            //.aspectRatio(1f, matchHeightConstraintsFirst = true)
            //.aspectRatio(default)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                //shape = CircleShape
            )
            .padding(3.dp)
           // .clip(CircleShape)
            //.fillMaxSize(1f)
    )
}

@Composable
fun Status(modifier:Modifier=Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier=modifier
    ){
        ProfileStatus(numberText = "5", text = "Posts")
        ProfileStatus(numberText = "0", text ="Followers" )
        ProfileStatus(numberText = "0", text = "Following")
    }

}

@Composable
fun ProfileStatus(
    numberText:String,
    text:String,
    modifier:Modifier=Modifier
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier=modifier
    ){
        Text(
            text=numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier=Modifier.height(4.dp))
        Text(text=text)
    }

}

@Composable
fun ProfileDesc(
    displayName:String,
    description:String
){
    val letterSpacing=0.5.sp
    val lineHeight=20.sp

    Column(
        modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ){
        Text(
            text=displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing=letterSpacing,
            lineHeight=lineHeight
        )
        Text(
            text=description,
            letterSpacing=letterSpacing,
            lineHeight=lineHeight
        )
    }
}

@Composable
fun ButtonSection(
    modifier:Modifier=Modifier
){
    val minWidth=95.dp
    val height=30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier=modifier
    ){
        ActionButton(
            text="Follow",
            icon=Icons.Default.KeyboardArrowDown,
            modifier= Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            text="Message",
            modifier= Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

        ActionButton(
            text="Email",
            modifier= Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )

    }
}

@Composable
fun ActionButton(
    modifier:Modifier=Modifier,
    text:String?=null,
    icon:ImageVector?=null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier= modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ){
        if(text!=null){
            Text(
                text=text,
                fontWeight = FontWeight.SemiBold,
                fontSize=14.sp
            )
        }
        if(icon!=null){
            Icon(
                imageVector=icon,
                contentDescription = null,
                tint=Color.Black
            )
        }
    }
}

@Composable
fun HighLightSection(modifier:Modifier=Modifier,
                      highlights:List<com.vipulasri.jetinstagram.data.ImageWithText>){
    LazyRow(modifier=Modifier){
        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end=15.dp)
            ){
               RoundImage(
                    image = highlights[it].image,
                modifier =Modifier.size(70.dp)
                )

                Text(
                    text=highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Composable
fun PostTabView(modifier:Modifier=Modifier,
                imageWithTexts:List<ImageWithText>,
            onTabSelected:(selectedIndex:Int)->Unit) {
    var selectedTabIndex by remember {
        mutableStateOf(0)

    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            )
            {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == 0) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts:List<Painter>,
    modifier:Modifier=Modifier
){
    LazyVerticalGrid(cells = GridCells.Fixed(3),
        modifier=modifier.scale(1.01f)
    ){
        items(posts.size){
            Image(
                painter=posts[it],
                contentDescription = null,
                contentScale=ContentScale.Crop,
                modifier= Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

