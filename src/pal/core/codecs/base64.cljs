(ns pal.core.codecs.base64
  (:require [pal.core.codecs :as codecs]
            [goog.crypt.base64 :as b64]))

(defn encode
  "Encode data to byte array base64.
  Accepts String and byte array as argument."
  ([data]
   (encode data false))
  ([data urlsafe?]
   (-> (codecs/to-bytes data)
       (b64/encodeByteArray urlsafe?)
       codecs/str->bytes)))

(defn decode
  "Decode base64 data into byte array.
  Accepts String and byte array as input
  argument."
  [data]
  (-> (codecs/to-bytes data)
      codecs/bytes->str
      b64/decodeStringToByteArray))
