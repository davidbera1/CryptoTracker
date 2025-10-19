package com.db.cryptotracker.crypto.domain

import com.db.cryptotracker.core.domain.util.NetworkError
import com.db.cryptotracker.core.domain.util.Result
import com.db.cryptotracker.crypto.domain.model.Coin

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}