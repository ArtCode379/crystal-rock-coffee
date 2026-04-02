package crystalrockcoffee.store.app.ui.composable.screen.order

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import crystalrockcoffee.store.app.R
import crystalrockcoffee.store.app.data.entity.OrderEntity
import crystalrockcoffee.store.app.ui.composable.shared.RSRKCContentWrapper
import crystalrockcoffee.store.app.ui.composable.shared.RSRKCEmptyView
import crystalrockcoffee.store.app.ui.state.DataUiState
import crystalrockcoffee.store.app.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel
import java.time.format.DateTimeFormatter

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {
        RSRKCContentWrapper(
            dataState = ordersState,

            dataPopulated = {
                val orders = (ordersState as DataUiState.Populated).data
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
                ) {
                    items(orders, key = { it.orderNumber }) { order ->
                        OrderCard(order = order)
                    }
                }
            },

            dataEmpty = {
                RSRKCEmptyView(
                    primaryText = stringResource(R.string.orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}

@Composable
private fun OrderCard(
    order: OrderEntity,
    modifier: Modifier = Modifier,
) {
    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.order_number, order.orderNumber),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A),
                )
                Surface(
                    shape = RoundedCornerShape(50.dp),
                    color = Color(0xFF27AE60).copy(alpha = 0.15f),
                ) {
                    Text(
                        text = stringResource(R.string.order_status_completed),
                        color = Color(0xFF27AE60),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = Color(0xFFE0E0E0))
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.order_customer, order.customerFirstName, order.customerLastName),
                fontSize = 13.sp,
                color = Color(0xFF555555),
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = order.timestamp.format(formatter),
                fontSize = 12.sp,
                color = Color(0xFF888888),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = order.description,
                fontSize = 13.sp,
                color = Color(0xFF555555),
                lineHeight = 20.sp,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Total: £%.2f".format(order.price),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD4AF37),
            )
        }
    }
}
