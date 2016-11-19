(ns pal.core.codecs
  "Util functions for make conversion between string, bytes
  and encode them to base64 ot hex format."
  (:require [goog.crypt :as gc]))

(defn str->bytes
  [s]
  (gc/stringToByteArray s))

(defn bytes->str
  [b]
  (gc/byteArrayToString b))

(defn hex->bytes
  [h]
  (gc/hexToByteArray h))

(defn bytes->hex
  [b]
  (gc/byteArrayToHex b))

(defprotocol IByteArray
  "Facility for convert input parameters
  to bytes array with default implementation
  for string an bytes array itself."
  (-to-bytes [this] "Represent this as byte array."))

(defn to-bytes
  "Encode as bytes."
  [v]
  (-to-bytes v))

(extend-protocol IByteArray
  array
  (-to-bytes [it] it)

  nil
  (-to-bytes [_]
    (array 0))

  string
  (-to-bytes [data] (str->bytes data)))
