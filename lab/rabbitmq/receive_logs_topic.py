import pika


connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()
channel.exchange_declare(exchange='topic_logs',
                            exchange_type='topic')
result = channel.queue_declare(exclusive=True)
queue_name = result.method.queue
####
import sys
binding_keys = sys.argv[1:]
for key in binding_keys:
    channel.queue_bind(exchange = 'topic_logs',
                        queue = queue_name,
                        routing_key = key)

####
print(' [*] Waiting for logs. To exit press CTRL+C')
# method : Meta information regarding the message delivery.
# properties : User-defined properties on the message.
def callback(ch, method, properties, body):
    print(" [x] %r:%r" % (method.routing_key, body))

channel.basic_consume(callback, queue=queue_name, no_ack=True)
channel.start_consuming()
