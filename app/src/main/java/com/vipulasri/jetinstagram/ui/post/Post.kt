package com.vipulasri.jetinstagram.ui.post

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.ui.components.icon
import com.vipulasri.jetinstagram.ui.home.Toolbar

@ExperimentalFoundationApi
@Composable
fun Post() {

    Column(modifier = Modifier.padding(10.dp)){
        PostToolbar()
        Spacer(modifier = Modifier.height(10.dp))
        Divider()
        Caption()
    }


}

@Composable
fun PostToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(56.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_backarrow),
                modifier = Modifier.icon(),
                contentDescription = ""
            )
            Text("New Post", fontSize = 20.sp)

            Button(onClick = {
                //your onclick code here
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)) {
                Text(text = "Share", color = Color.Blue,)
            }


    }
}

@Composable
fun Caption(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(top=10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ab1_inversions),
            contentDescription = null
        )
       Text("Write a caption"
            )

    }
}

