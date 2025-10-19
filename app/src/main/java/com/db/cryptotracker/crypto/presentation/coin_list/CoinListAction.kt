package com.db.cryptotracker.crypto.presentation.coin_list

import com.db.cryptotracker.crypto.presentation.model.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}