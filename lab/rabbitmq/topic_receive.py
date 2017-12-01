import pika

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()
channel.exchange_declare(exchange='topic_exchange', exchange_type = 'topic')
result = channel.queue_declare(exclusive=True)
queue_name = result.method.queue
channel.queue_bind(exchange='topic_exchange', queue=queue_name, routing_key='*.1130')
print(' [*] Waiting for logs. To exit press CTRL+C')
def callback(ch, method, properties, body):
    print ('key = ', method.routing_key,' body = ',body)
channel.basic_consume(callback, queue=queue_name)
channel.start_consuming()
