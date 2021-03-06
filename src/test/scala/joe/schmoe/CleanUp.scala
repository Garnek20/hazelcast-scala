package joe.schmoe

import com.hazelcast.core.HazelcastInstance
import collection.JavaConverters._

trait CleanUp {

  def hzs: Vector[HazelcastInstance]

  def cleanup() {
    hzs.foreach { hz =>
      hz.getDistributedObjects.asScala.foreach(_.destroy)
    }
  }
}
