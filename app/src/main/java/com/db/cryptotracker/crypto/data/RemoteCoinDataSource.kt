package com.db.cryptotracker.crypto.data

import com.db.cryptotracker.core.data.networking.constructUrl
import com.db.cryptotracker.core.data.networking.safeCall
import com.db.cryptotracker.core.domain.util.NetworkError
import com.db.cryptotracker.core.domain.util.Result
import com.db.cryptotracker.core.domain.util.map
import com.db.cryptotracker.crypto.data.mapper.toCoin
import com.db.cryptotracker.crypto.data.model.CoinsResponseDto
import com.db.cryptotracker.crypto.domain.CoinDataSource
import com.db.cryptotracker.crypto.domain.model.Coin
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}