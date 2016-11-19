(ns pal.core.nonce
  (:require [cljs.nodejs :as nodejs]))

(defn random-bytes
  [numbytes]
  (-> (.randomBytes (nodejs/require "crypto") numbytes)
      .toJSON
      .-data))
