import pika
import uuid

class FibonacciRpcClient(object):

#Establish a connection, channel and declare an exclusive 'callback' queue for replies.
    def __init__(self):
        self.connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))

        self.channel = self.connection.channel()

        result = self.channel.queue_declare(exclusive=True)
        self.callback_queue = result.method.queue

        self.channel.basic_consume(self.on_response, no_ack=True,

#We subscribe to the 'callback' queue, so that we can receive RPC responses.
                                    queue=self.callback_queue)
#Execute when getting respnse from server
    def on_response(self, ch, method, props, body):
        if self.corr_id == props.correlation_id:
            self.response = body
#It does the actual RPC request.
    def call(self, n):
        self.response = None

#Generate a unique correlation_id number and save it.
        self.corr_id = str(uuid.uuid4())
#Publish the request message, with two properties: reply_to and correlation_id.
        self.channel.basic_publish( exchange='',
                                    routing_key='rpc_queue',
                                    properties=pika.BasicProperties(
                                                reply_to= self.callback_queue,
                                                correlation_id=self.corr_id,),
#And message body.
                                    body=str(n))

#Wait until the proper response arrives.
        while self.response is None:
            self.connection.process_data_events()
        return int(self.response)

#Client Interface
fibonacci_rpc = FibonacciRpcClient()
print(" [x] Requesting fib(30)")
response = fibonacci_rpc.call(30)
print(" [.] Got %r" % response)
