import pika
import sys


connection = pika.BlockingConnection(pika.ConnectionParameters(host = 'localhost'))
channel = connection.channel()
channel.exchange_declare(exchange = 'topic_logs', exchange_type = 'topic')
routing_key = sys.argv[1]
channel.basic_publish(exchange = 'topic_logs',
                        routing_key = routing_key,
                        body = 'A topic msg.')
print('[X]Send a topic msg with routing_key = ', routing_key)
connection.close()
