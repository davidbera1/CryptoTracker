package com.db.cryptotracker.crypto.data.mapper

import com.db.cryptotracker.crypto.data.model.CoinDto
import com.db.cryptotracker.crypto.domain.model.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}