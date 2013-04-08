package edu.spbstu.wfsmp.sensor;

/**
 * User: artegz
 * Date: 13.10.12
 * Time: 22:21
 */
public interface ProtocolCommandCodes {

    // implemented commands
    String REQUEST_SERIAL_NUMBER        = "#S";
    String RESPONSE_SERIAL_NUMBER       = "*S";
    String REQUEST_DATA_BASE_OUT        = "#B";
    String RESPONSE_DATA_BASE_OUT       = "*B";
    String REQUEST_START                = "#b";
    String RESPONSE_START               = "*b";
    String REQUEST_STOP                 = "#b";
    String RESPONSE_STOP                = "*b";
    String RESPONSE_NOK                 = "*?";

    String REQUEST_FREQUENCY_OUT        = "#f";
    String RESPONSE_FREQUENCY_OUT       = "*f";
    String REQUEST_VELOCITY_OUT         = "#v";
    String RESPONSE_VELOCITY_OUT        = "*v";
    String REQUEST_TURN_NUMBER_OUT      = "#n";
    String RESPONSE_TURN_NUMBER_OUT     = "*n";
    String REQUEST_MEASURE_TIME_OUT     = "#t";
    String RESPONSE_MEASURE_TIME_OUT    = "*t";
    String REQUEST_STATUS_OUT           = "#s";
    String RESPONSE_STATUS_OUT          = "*s";
    String REQUEST_REAL_TIME_OUT        = "#T";
    String RESPONSE_REAL_TIME_OUT       = "*T";
    String REQUEST_REAL_DATE_OUT        = "#D";
    String RESPONSE_REAL_DATE_OUT       = "*D";

    String REQUEST_SAVE                 = "#w";
    String RESPONSE_SAVE                = "*w";

    String REQUEST_DB_SIZE              = "#N";
    String RESPONSE_DB_SIZE             = "*N";

    String REQUEST_CLEAR_DB             = "#c";
    String RESPONSE_CLEAR_DB            = "*c";

    String a = "#N/r/n"; // db rows count
    String a1 = "#wllldd/r/n"; // write current
    // "#c/r/n"  clear db

    // set whirwind type - "#md/r/n"
    // set time - "#Thhmmss/r/n"
    // set date - "#DddMMyy/r/n"
    // set display "#dm/r/n"




    String ERROR                        = "*?\r\n";


    // not implemented commands
    String REQUEST_EEPROM_DATA_OUT      = "#R";

    String REQUEST_NUM_RECORDS_OUT      = "#N";
    String REQUEST_WRITE_RECORD         = "#w";
    String REQUEST_CLEAR                = "#c";
    String REQUEST_SET_MODE             = "#m";
    String REQUEST_SET_DISPLAY          = "#d";

    String REQUEST_SOUND_SET            = "#z"; // 1|0
    String REQUEST_GROUND_SET           = "#k"; // 1|0
    String REQUEST_SOFT_RESET           = "#r";
    String REQUEST_WRITE_BYTE           = "#P";
    String REQUEST_SLEEP                = "#e";
    String REQUEST_PROMT_OUTPUT         = "#H";
    String REQUEST_NUMBER_VERSIE_OUTPUT = "#V";


    // String NO_RESPONSE              = "NO_RESPONSE_FAKE_COMMAND";
}
