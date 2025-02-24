package nextstep.payments.ui.updatecard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import nextstep.payments.designsystem.component.CardInfoScreen

@Composable
fun UpdateCardScreen(
    onBackClick: () -> Unit,
    onUpdate: () -> Unit,
    viewModel: UpdateCardViewModel,
    modifier: Modifier = Modifier
) {

    val cardNumber by viewModel.cardNumber.collectAsStateWithLifecycle()
    val expiredDate by viewModel.expiredDate.collectAsStateWithLifecycle()
    val ownerName by viewModel.ownerName.collectAsStateWithLifecycle()
    val password by viewModel.password.collectAsStateWithLifecycle()

    val cardUpdated by viewModel.cardUpdated.collectAsStateWithLifecycle()
    val selectBank by viewModel.selectBank.collectAsStateWithLifecycle()

    LaunchedEffect(cardUpdated) {
        if (cardUpdated) {
            onUpdate()
        }
    }

    CardInfoScreen(
        cardNumber = cardNumber,
        expiredDate = expiredDate,
        ownerName = ownerName,
        password = password,
        bankType = selectBank,
        setCardNumber = viewModel::setCardNumber,
        setExpiredDate = viewModel::setExpiredDate,
        setOwnerName = viewModel::setOwnerName,
        setPassword = viewModel::setPassword,
        setBankType = viewModel::setBankType,
        onBackClick = onBackClick,
        onSaveClick = viewModel::updateCard,
        modifier = modifier
    )

}