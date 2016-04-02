package org.revo.Service

import org.revo.model.ErrorMessage
import java.util.logging.Logger

/**
 * Created by revo on 23/01/16.
 */
interface LoggerService {
    def Error(Logger logger, ErrorMessage em)
}