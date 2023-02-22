package com.nanioi.data.repositoryimpl

import com.nanioi.data.service.MIMSService
import com.nanioi.domain.repository.MIMSRepository

class MIMSRepositoryImpl(
    private val service: MIMSService
) : MIMSRepository {
}